package com.kamuridesu.social_scheduler.domain.service;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kamuridesu.social_scheduler.domain.model.Post;
import com.kamuridesu.social_scheduler.domain.model.SocialMedia;
import com.kamuridesu.social_scheduler.domain.repository.PostRepository;
import com.kamuridesu.social_scheduler.domain.repository.SocialMediaRepository;
import com.kamuridesu.social_scheduler.domain.repository.UserRepository;
import com.kamuridesu.social_scheduler.support.constants.RabbitConsts;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostSchedulerService {

    private final AmqpTemplate amqpTemplate;
    private final SocialMediaRepository socialMediaRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private void publish(Post post) {
        log.info("Post id: " + post.getId());
        log.info("Delay: " + post.getDelay());
        Message message = MessageBuilder.withBody(String.valueOf(post.getBody()).getBytes())
            .setHeader("x-delay", post.getDelay())
            .build();
        amqpTemplate.send(RabbitConsts.Exchanges.SCHEDULE_EXCHANGE, RabbitConsts.RoutingKeys.SCHEDULE_ROUTING_KEY, message);
        log.info("Message sent");
    }

    public Post schedule(Long socialId, Post post) {
        return socialMediaRepository.findById(socialId)
            .map(social -> {
                post.setCreatedAt(LocalDateTime.now());
                post.setSocial(social);
                Post savedPost = postRepository.save(post);
                publish(post);
                return savedPost;
            })
            .orElse(null);
    }

    public SocialMedia registerSocialMedia(Long userId, SocialMedia social) {
        return userRepository.findById(userId)
            .map(user -> {
                social.setUser(user);
                var savedSocial = socialMediaRepository.save(social);
                return savedSocial;
            }).orElse(null);
    }

}

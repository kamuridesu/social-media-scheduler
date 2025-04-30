package com.kamuridesu.social_scheduler.domain.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.kamuridesu.social_scheduler.domain.repository.PostRepository;
import com.kamuridesu.social_scheduler.support.constants.RabbitConsts;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostConsumerService {

    private final PostRepository postRepository;

    @RabbitListener(queues = RabbitConsts.Queues.SCHEDULE_QUEUE)
    public void listen(String rawPostId) {
        Long postId = Long.valueOf(rawPostId);
        var posts = postRepository.findById(postId);
        posts.ifPresent(
                s -> System.out.println(s.getId()));
        System.out.println(posts);
    }

    @RabbitListener(queues = RabbitConsts.Queues.DQL)
    public void listenDQL(String in) {
        System.out.println(in);
    }

}

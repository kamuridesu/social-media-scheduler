package com.kamuridesu.social_scheduler.domain.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kamuridesu.social_scheduler.domain.model.Post;
import com.kamuridesu.social_scheduler.domain.repository.PostRepository;
import com.kamuridesu.social_scheduler.domain.repository.UserRepository;
import com.kamuridesu.social_scheduler.support.constants.RabbitConsts;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostSchedulerService {

    private final AmqpTemplate amqpTemplate;

    public void publish() {
        Message message = MessageBuilder.withBody("Test".getBytes())
            .setHeader("x-delay", 5000)
            .build();
        amqpTemplate.send(RabbitConsts.Exchanges.SCHEDULE_EXCHANGE, RabbitConsts.RoutingKeys.SCHEDULE_ROUTING_KEY, message);
    }

    void schedule(Post post) {
        // postRepository.save(post);
    }

}

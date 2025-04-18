package com.kamuridesu.social_scheduler.domain.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.kamuridesu.social_scheduler.support.constants.RabbitConsts;

@Service
public class PostConsumerService {

    @RabbitListener(queues = RabbitConsts.Queues.SCHEDULE_QUEUE)
    public void listen(String in) {
        System.out.println(in);
    }

}

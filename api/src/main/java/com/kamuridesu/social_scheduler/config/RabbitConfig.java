package com.kamuridesu.social_scheduler.config;

import java.util.HashMap;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kamuridesu.social_scheduler.support.constants.RabbitConsts;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    @Bean
    public CustomExchange schedulerExchange() {
        return new CustomExchange(
                RabbitConsts.Exchanges.SCHEDULE_EXCHANGE,
                "x-delayed-message",
                true,
                false,
                new HashMap<String, Object>() {
                    {
                        put("x-delayed-type", "direct");
                    }
                });
    }

    @Bean
    public Queue scheduleQueue() {
        return new Queue(RabbitConsts.Queues.SCHEDULE_QUEUE);
    }

    @Bean
    public Binding scheduleBinding(Queue scheduleQueue, CustomExchange schedulerExchange) {
        return BindingBuilder
                .bind(scheduleQueue)
                .to(schedulerExchange)
                .with(RabbitConsts.RoutingKeys.SCHEDULE_ROUTING_KEY)
                .noargs();
    }

    @Bean
    public Queue processQueue() {
        return new Queue(RabbitConsts.Queues.PROCESS_QUEUE);
    }

    @Bean
    public Binding processBinding(Queue processQueue, CustomExchange schedulerExchange) {
        return BindingBuilder
                .bind(processQueue)
                .to(schedulerExchange)
                .with(RabbitConsts.RoutingKeys.PROCESS_ROUTING_KEY)
                .noargs();
    }

}

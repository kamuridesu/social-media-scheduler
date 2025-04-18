package com.kamuridesu.social_scheduler.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.DirectExchange;
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
                RabbitConsts.Args.EXCHANGE_ARGS);
    }

    @Bean
    public DirectExchange scheduleDLExchange() {
        return new DirectExchange(RabbitConsts.Exchanges.DLX);
    }

    @Bean
    public Queue scheduleQueue() {
        return new Queue(RabbitConsts.Queues.SCHEDULE_QUEUE,
                true,
                false,
                false,
                RabbitConsts.Args.QUEUE_ARGS);
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
    public Queue scheduleDLQueue() {
        return new Queue(RabbitConsts.Queues.DQL, true);
    }

    @Bean
    public Binding scheduleDLQBinding(Queue scheduleDLQueue, DirectExchange scheduleDLExchange) {
        return BindingBuilder
                .bind(scheduleDLQueue)
                .to(scheduleDLExchange)
                .with(RabbitConsts.RoutingKeys.SCHEDULE_DL_ROUTING_KEY);
    }

}

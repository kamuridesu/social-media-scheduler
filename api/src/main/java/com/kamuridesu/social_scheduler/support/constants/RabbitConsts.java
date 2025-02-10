package com.kamuridesu.social_scheduler.support.constants;

import java.util.HashMap;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RabbitConsts {

    @NoArgsConstructor
    public static final class Exchanges {

        public static final String SCHEDULE_EXCHANGE = "scheduled-exchange";
        public static final String DLX = SCHEDULE_EXCHANGE + ".dlx";

    }

    @NoArgsConstructor
    public static final class Queues {

        public static final String SCHEDULE_QUEUE = "scheduled.queue";
        public static final String DQL = SCHEDULE_QUEUE + ".dlq";

    }

    @NoArgsConstructor
    public static final class RoutingKeys {

        public static final String SCHEDULE_ROUTING_KEY = "schedule-routing-key";
        public static final String SCHEDULE_DL_ROUTING_KEY = SCHEDULE_ROUTING_KEY + ".dl";

    }

    @NoArgsConstructor
    public static final class Args {
        public final static HashMap<String, Object> QUEUE_ARGS = new HashMap<>() {
            {
                put("x-dead-letter-exchange", RabbitConsts.Exchanges.DLX);
                put("x-dead-letter-routing-key", RabbitConsts.Queues.DQL);
                put("x-queue-type", "quorum");
            }
        };

        public final static HashMap<String, Object> EXCHANGE_ARGS = new HashMap<>() {
            {
                put("x-delayed-type", "direct");
            }
        };
    }

}

package com.kamuridesu.social_scheduler.support.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RabbitConsts {
    
    @NoArgsConstructor
    public static final class Exchanges {
        
        public static final String SCHEDULE_EXCHANGE = "scheduled-exchange";

    }

    @NoArgsConstructor
    public static final class Queues {

        public static final String SCHEDULE_QUEUE = "scheduled.queue";
        public static final String PROCESS_QUEUE = "process.queue";
        public static final String PROCESS_DL_QUEUE = "process.dl";
        
    }

    @NoArgsConstructor
    public static final class RoutingKeys {

        public static final String PROCESS_DL_ROUTING_KEY = "process.dl-routing-key";
        public static final String PROCESS_ROUTING_KEY = "process-routing-key";
        public static final String SCHEDULE_ROUTING_KEY = "schedule-routing-key";

    }
    
}

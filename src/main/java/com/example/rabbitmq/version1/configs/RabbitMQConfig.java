package com.example.rabbitmq.version1.configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "custom-local-queue";
    public static final String EXCHANGE_NAME = "custom-local-exchange";
    public static final String ROUTING_KEY = "custom.local.routing.key";
    private static final boolean DURABLE = true;

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, DURABLE);
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ROUTING_KEY);
    }
}

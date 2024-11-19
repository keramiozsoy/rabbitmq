package com.example.rabbitmq.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    public TopicExchange exchange() {
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

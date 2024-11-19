package com.example.rabbitmq.version2.configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "notification-exchange";
    public static final String SMS_QUEUE = "sms-queue";
    public static final String EMAIL_QUEUE = "email-queue";
    public static final String PUSH_QUEUE = "push-queue";
    //
    private static final String ROUTING_KEY_NOTIFICATION_SMS = "notification.sms";
    private static final String ROUTING_KEY_NOTIFICATION_EMAIL = "notification.email";
    private static final String ROUTING_KEY_NOTIFICATION_PUSH = "notification.push";
    //
    private static final boolean DURABLE = true;

    @Bean
    public Exchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE, DURABLE);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE, DURABLE);
    }

    @Bean
    public Queue pushQueue() {
        return new Queue(PUSH_QUEUE, DURABLE);
    }

    @Bean
    public Binding smsBinding(Queue smsQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(smsQueue)
                .to(exchange)
                .with(ROUTING_KEY_NOTIFICATION_SMS);
    }

    @Bean
    public Binding emailBinding(Queue emailQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(emailQueue)
                .to(exchange)
                .with(ROUTING_KEY_NOTIFICATION_EMAIL);
    }

    @Bean
    public Binding pushBinding(Queue pushQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(pushQueue)
                .to(exchange)
                .with(ROUTING_KEY_NOTIFICATION_PUSH);
    }
}
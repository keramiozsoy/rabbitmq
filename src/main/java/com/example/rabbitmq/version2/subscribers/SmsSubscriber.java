package com.example.rabbitmq.version2.subscribers;

import com.example.rabbitmq.version2.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SmsSubscriber {
    @RabbitListener(queues = RabbitMQConfig.SMS_QUEUE)
    public void subscribe(String message) {
        System.out.println("SMS received: " + message);
    }
}

package com.example.rabbitmq.version2.subscribers;

import com.example.rabbitmq.version2.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailSubscriber {
    @RabbitListener(queues = RabbitMQConfig.EMAIL_QUEUE)
    public void subscribe(String message) {
        System.out.println("Email received: " + message);
    }
}

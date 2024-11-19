package com.example.rabbitmq.version2.subscribers;

import com.example.rabbitmq.version2.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PushSubscriber {
    @RabbitListener(queues = RabbitMQConfig.PUSH_QUEUE)
    public void subscribe(String message) {
        System.out.println("Push received: " + message);
    }
}

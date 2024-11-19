package com.example.rabbitmq.subscribers;

import com.example.rabbitmq.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageSubscriber {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void subscribe(String message){
        System.out.println("subscriber() : " + message);
    }
}

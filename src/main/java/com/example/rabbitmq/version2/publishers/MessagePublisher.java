package com.example.rabbitmq.version2.publishers;

import com.example.rabbitmq.version2.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publish(String routingKey, String message){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                routingKey,
                message
        );
        System.out.println("publish() : " + " key: " + routingKey + " message: " + message);
    }
}

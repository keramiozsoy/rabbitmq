package com.example.rabbitmq.api;

import com.example.rabbitmq.publishers.MessagePublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessagePublisher messagePublisher;

    public MessageController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }


    @GetMapping("/publish")
    public String publishMessage(@RequestParam String message){
        messagePublisher.publish(message);
        return "Message published : " + message;
    }
}

package com.example.rabbitmq.version2.apis;

import com.example.rabbitmq.version2.publishers.MessagePublisher;
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
    public String publishMessage(@RequestParam String type, @RequestParam String message){
        String routingKey = "notification." + type;
        messagePublisher.publish(routingKey, message);
        return "Message published : " + message;
    }
}

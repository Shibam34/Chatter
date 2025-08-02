package com.chatter.controller;

import com.chatter.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/messages")
public class ChatterController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping
    public String publishMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        return "Message published to Kafka topic";
    }
}
package com.fauzanlm.springkafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fauzanlm.springkafka.services.KafkaProducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private KafkaProducer kafkaProducer;
    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Send Message Successful");
    }
    
}

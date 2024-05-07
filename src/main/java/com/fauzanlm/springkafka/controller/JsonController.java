package com.fauzanlm.springkafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fauzanlm.springkafka.model.User;
import com.fauzanlm.springkafka.services.KafkaJsonProducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v2/message")
public class JsonController {
    KafkaJsonProducer kafkaJsonProducer;

    public JsonController(KafkaJsonProducer kafkaJsonProducer){
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        //TODO: process POST request
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Success to send json message to kafka");
    }
    
}

package com.fauzanlm.springkafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.fauzanlm.springkafka.model.User;

@Service
public class KafkaJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("message json successfully sent : %s", user.toString()));
        Message<User> msg = MessageBuilder
        .withPayload(user)
        .setHeader(KafkaHeaders.TOPIC, "topic2Json")
        .build();

        kafkaTemplate.send(msg);
    }
}

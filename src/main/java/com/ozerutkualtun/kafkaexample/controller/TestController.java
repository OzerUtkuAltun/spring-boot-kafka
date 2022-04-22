package com.ozerutkualtun.kafkaexample.controller;

import com.ozerutkualtun.kafkaexample.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Value("${kafka-example.kafka.topic}")
    private String kafkaTopic;


    @PostMapping
    public void sendMessageToKafka(@RequestBody KafkaMessage kafkaMessage) {

        kafkaTemplate.send(kafkaTopic, UUID.randomUUID().toString(), kafkaMessage);

    }
}

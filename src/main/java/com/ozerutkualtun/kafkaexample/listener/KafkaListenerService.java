package com.ozerutkualtun.kafkaexample.listener;

import com.ozerutkualtun.kafkaexample.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService {

    @KafkaListener(topics = "${kafka-example.kafka.topic}", groupId = "${kafka-example.kafka.group}")
    public void listen(@Payload KafkaMessage kafkaMessage) {

        log.info("\n----------- MESSAGE RECEIVED. --------------\n " +
                        "Id: {} \n" +
                        "Service: {}\n" +
                        "Message Content: {}\n" +
                        "TimeStamp: {}\n",
                kafkaMessage.getId(), kafkaMessage.getService(), kafkaMessage.getMessage(), kafkaMessage.getTimeStamp());

    }
}

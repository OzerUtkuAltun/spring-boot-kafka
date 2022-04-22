package com.ozerutkualtun.kafkaexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessage {

    private String id = UUID.randomUUID().toString();
    private String service;
    private String message;
    private String timeStamp = new Timestamp(System.currentTimeMillis()).toString();

}

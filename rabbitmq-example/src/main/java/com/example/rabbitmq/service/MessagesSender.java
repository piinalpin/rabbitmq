package com.example.rabbitmq.service;

import com.example.rabbitmq.constant.QueueConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessagesSender {

    private final static Logger log = LoggerFactory.getLogger(MessagesSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void send(String name) {
        log.info("Sending message to RabbitMQ...");
        rabbitTemplate.convertAndSend(QueueConstant.HELLO_WORLD, String.format("Hello my name is %s", name));
    }

    public void sendEmail(Map<String, String> map) {
        log.info("Sending message to RabbitMQ...");
        try {
            rabbitTemplate.convertAndSend(QueueConstant.EMAIL, mapper.writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

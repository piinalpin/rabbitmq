package com.example.rabbitmqlistener.service;

import com.example.rabbitmqlistener.constant.QueueConstant;
import com.example.rabbitmqlistener.model.EmailModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerService {

    private final static Logger log = LoggerFactory.getLogger(MessageListenerService.class);

    private final ObjectMapper mapper;

    @Autowired
    public MessageListenerService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @RabbitListener(queues = QueueConstant.HELLO_WORLD)
    public void greeting(String message) {
        log.info("Receiving message...");
        log.info("Message is: " + message);
    }

    @RabbitListener(queues = QueueConstant.EMAIL)
    public void sendEmail(String message) {
        log.info("Receiving message: " + message);
        try {
            EmailModel email = mapper.readValue(message, EmailModel.class);
            log.info("Converting to model...");
            log.info("EmailModel:: " + email.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

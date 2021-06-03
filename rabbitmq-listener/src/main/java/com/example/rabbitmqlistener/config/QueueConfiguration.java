package com.example.rabbitmqlistener.config;

import com.example.rabbitmqlistener.constant.QueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

    @Bean
    public Queue helloWorld() {
        return new Queue(QueueConstant.HELLO_WORLD);
    }

    @Bean
    public Queue sendEmail() {
        return new Queue(QueueConstant.EMAIL);
    }

}

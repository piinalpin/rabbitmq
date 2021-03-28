package com.example.rabbitmq.controller;

import com.example.rabbitmq.service.MessagesSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicationController {

    private final MessagesSender messagesSender;

    @Autowired
    public ApplicationController(MessagesSender messagesSender) {
        this.messagesSender = messagesSender;
    }

    @PostMapping(value = "/hello-world", name = "Hello World")
    public Map<String, String> hello(@RequestBody Map<String, String> request) {
        messagesSender.send(request.get("name"));

        Map<String, String> ret = new HashMap<>();
        ret.put("message", "sending message...");
        return ret;
    }

    @PostMapping(value = "/sendEmail", name = "Send Email")
    public Map<String, String> sendEmail(@RequestBody Map<String, String> request) {
        messagesSender.sendEmail(request);

        Map<String, String> ret = new HashMap<>();
        ret.put("message", "sending your email...");
        return ret;
    }

}

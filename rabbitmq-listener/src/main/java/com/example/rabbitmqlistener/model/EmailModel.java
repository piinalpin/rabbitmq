package com.example.rabbitmqlistener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    private String from;

    private String to;

    private String subject;

    private String message;

    private String name;

}

package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.OutputStrategy;

public class Console implements OutputStrategy {
    @Override
    public void outputDevice(Message message) {
        System.out.println("log on console input: " + message.getMessageKey()+ "and total sum:" +  message.getMessageValue());
    }
}

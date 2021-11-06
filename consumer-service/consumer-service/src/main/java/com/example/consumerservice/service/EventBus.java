package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.OutputStrategy;

public class EventBus implements OutputStrategy {
    @Override
    public void outputDevice(Message message) {
        System.out.println("log on event bus input:" + message.getMessageKey()+ "and total sum:" +  message.getMessageValue());
    }
}

package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.OutputStrategy;

public class EventBus implements OutputStrategy {
    @Override
    public void outputDevice(Message message) {
        System.out.println(String.format("log on event bus input: %1$s and total sum: %2s", message.getMessageKey(), message.getMassageValue()));
    }
}

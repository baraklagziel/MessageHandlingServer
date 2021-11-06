package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.OutputStrategy;

public class Printer implements OutputStrategy {
    @Override
    public void outputDevice(Message message) {
        System.out.println(String.format("Print with printer input: %1$s and total sum: %2s", message.getMessageKey(), message.getMassageValue()));
    }
}

package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.OutputStrategy;

public class Printer implements OutputStrategy {
    @Override
    public void outputDevice(Message message) {
        System.out.println("messgage: " + message.getMessageKey());
        System.out.println("messgage: " + message.getMessageValue());
        System.out.println("Print with printer input: " + message.getMessageKey()+ " total sum:" +  message.getMessageValue());
    }
}

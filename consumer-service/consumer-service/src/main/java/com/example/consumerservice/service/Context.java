package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.OutputStrategy;

public class Context {
    private final OutputStrategy strategy;

    public Context(OutputStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Message message){
        strategy.outputDevice(message);
    }
}

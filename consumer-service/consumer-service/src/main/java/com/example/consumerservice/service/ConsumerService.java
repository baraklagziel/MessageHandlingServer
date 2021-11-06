package com.example.consumerservice.service;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.IMessageService;

public class ConsumerService implements IMessageService {
    private volatile int sum;

    @Override
    public Message createMessage(Message Message) {
        return null;
    }

    @Override
    public void updateSum(String inputValue) {
        this.sum += Integer.parseInt(inputValue);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

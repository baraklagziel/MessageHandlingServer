package com.example.consumerservice.service.impl;

import com.example.consumerservice.model.Message;

public interface OutputStrategy {
    public void outputDevice(Message message);
}

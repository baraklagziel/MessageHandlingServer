package com.example.consumerservice.service.impl;

import com.example.consumerservice.model.Message;

public interface IMessageService {
    void createMessage(String messageKey, String messageValue);
    void updateSum(String num);
}

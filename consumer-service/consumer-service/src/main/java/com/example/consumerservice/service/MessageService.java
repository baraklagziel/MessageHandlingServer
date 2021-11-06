package com.example.consumerservice.service;

import com.example.consumerservice.exception.BadRequestException;
import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.IMessageService;

public class MessageService implements IMessageService {
    @Override
    public Message createMessage(Message message) {
        if(message == null) {
            throw new BadRequestException("Message content must be provided");
        }

        //Save message
        return null;
    }

    @Override
    public void updateSum(String num) {

    }
}

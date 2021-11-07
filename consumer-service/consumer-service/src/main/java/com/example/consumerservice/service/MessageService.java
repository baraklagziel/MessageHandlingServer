package com.example.consumerservice.service;

import com.example.consumerservice.exception.BadRequestException;
import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.impl.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private volatile int sum;
    private String messageKey;
    private String messageValue;


    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    @Override
    public void createMessage(String messageKey, String messageValue) {
        if(messageKey == null || messageValue == null ) {
            throw new BadRequestException("Message content must be provided");
        }

        this.messageKey = messageKey;
        this.messageValue = messageValue;
    }

    @Override
    public void updateSum(String inputValue) {
        sum += Integer.parseInt(inputValue);
    }


}

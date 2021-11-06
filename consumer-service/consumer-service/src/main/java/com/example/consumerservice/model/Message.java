package com.example.consumerservice.model;

public class Message {
    private String messageKey;
    private int messageValue;

    public Message(String messageKey, int messageValue) {
        this.messageKey = messageKey;
        this.messageValue = messageValue;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public int getMessageValue() {
        return messageValue;
    }

    public void setMassageValue(int messageValue) {
        this.messageValue = messageValue;
    }
}

package com.MessageServer.rest.webservices.restfulwebservices.model;

public  class MessageWrapper {
    private String messageKey;
    private int sum;

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public int getMessageValue() {
        return sum;
    }

    public void setMessageValue(int sum) {
        this.sum = sum;
    }

    public MessageWrapper(String messageKey, int messageValue) {
        this.messageKey = messageKey;
        this.sum = messageValue;
    }

    public MessageWrapper(){}

    @Override
    public String toString() {
        return "{\"messageKey\":\"messageKey\",\"sum\":\"sum\"}";
    }
}

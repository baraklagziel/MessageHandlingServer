package com.MessageServer.rest.webservices.restfulwebservices.model;

public  class MessageWrapper {
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

    public MessageWrapper(String messageKey, String messageValue) {
        this.messageKey = messageKey;
        this.messageValue = messageValue;
    }

    public MessageWrapper(){}
}

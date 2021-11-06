package com.example.consumerservice.model;

public class Message {
    private String messageKey;
    private String massageVale;

    public Message(String messageKey, String massageVale) {
        this.messageKey = messageKey;
        this.massageVale = massageVale;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMassageValue() {
        return massageVale;
    }

    public void setMassageValue(String massageVale) {
        this.massageVale = massageVale;
    }
}

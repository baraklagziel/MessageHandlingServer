package com.example.consumerservice.model;

public class  SumMessage {
    public String messageKey;
    public String sum;

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public SumMessage(String messageKey, String sum) {
        this.messageKey = messageKey;
        this.sum = sum;
    }
}

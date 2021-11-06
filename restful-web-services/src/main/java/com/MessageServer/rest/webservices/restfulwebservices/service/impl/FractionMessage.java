package com.MessageServer.rest.webservices.restfulwebservices.service.impl;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.Type;

public class FractionMessage extends Message {

    public FractionMessage(String message) {
        super(message, Type.FRACTION);
    }

    @Override
    public int getValue() {
        String array[] = getContent().split(":");
        if(array.length == 0) return 0;
        value = Integer.parseInt(array[0]);

        for (int i = 1; i < array.length; i++) {
            value /= Integer.parseInt(array[i]);
        }

        return value;
    }
}

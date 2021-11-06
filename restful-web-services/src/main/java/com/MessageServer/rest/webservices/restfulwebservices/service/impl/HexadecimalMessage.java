package com.MessageServer.rest.webservices.restfulwebservices.service.impl;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.Type;

public class HexadecimalMessage extends Message {

    public HexadecimalMessage(String message) {
        super(message, Type.HEX);
    }

    @Override
    public int getValue() {
       return Integer.parseInt(getContent().trim(), 16 );
    }

    public boolean isPositive() {
        int value = getValue();
        return value > 0;
    }
}

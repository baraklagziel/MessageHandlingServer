package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessage;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;

public class HexadecimalMessage extends Message {

    public HexadecimalMessage(String message) {
        super(message, Type.HEX);
    }

    @Override
    public int getValue() {
       return Integer.parseInt(getContent().trim(), 16 );
    }



}

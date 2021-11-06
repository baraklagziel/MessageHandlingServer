package com.MessageServer.rest.webservices.restfulwebservices.service.impl;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.Type;

import java.util.regex.Pattern;

public class StringMessage extends Message {
    private static final String POSITIVE_INTEGER_REGEX = "[0-9]+";
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile(POSITIVE_INTEGER_REGEX);

    public StringMessage(String message) {
        super(message, Type.STRING);
    }

    public int getValue() {
        return Integer.parseInt(getContent());
    }

    public boolean isPositive() {
        return POSITIVE_INTEGER_PATTERN.matcher(getContent()).matches();
    }
}

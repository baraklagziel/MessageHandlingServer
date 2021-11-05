package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.ICheckPositive;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexadecimalMessage implements IMessageType {
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");
    private Message message;
    private int value;

    public HexadecimalMessage(Message message) {
        this.message = message;
    }
    @Override
    public Type getType() {
        return Type.HEX;
    }

    @Override
    public int convertByType() {
       return Integer.parseInt(message.getContent().trim(), 16 );
    }

    public static boolean isHexadecimal(String input) {
        final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
        return matcher.matches() && input.length() == 1;
    }

    @Override
    public boolean isPositive() {
        return convertByType() > 0;
    }

}

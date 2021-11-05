package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.ICheckPositive;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.util.NumberUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMessage implements IMessageType{
    private Message message;
    private static final String POSITIVE_INTEGER_REGEX = "[0-9]+";
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile(POSITIVE_INTEGER_REGEX);

    public StringMessage(Message message) {
        this.message = message;
    }

    @Override
    public Type getType() {
        return Type.STRING;
    }

    @Override
    public int convertByType() {
        return Integer.parseInt(this.message.getContent());
    }

    public static boolean isString(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    @Override
    public  boolean isPositive() {
        return POSITIVE_INTEGER_PATTERN.matcher(this.message.getContent()).matches();
    }
}

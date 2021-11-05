package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeFactory {

    public IMessageType getMessageType(Message message) {
        Type messageType = getType(message.getContent());

        if (messageType == Type.HEX) {
            return new HexadecimalMessage(message);

        } else if (messageType == Type.FRACTION) {
            return new FractionMessage(message);

        } else if (messageType == Type.STRING) {
            return new StringMessage(message);
        }

        return null;
    }

    private Type getType(String content) {
        if(isHexadecimal(content)) return Type.HEX;
        if(isFraction(content)) return Type.FRACTION;
        if(isString(content)) return Type.STRING;

        return null;
    }

    private boolean isHexadecimal(String input) {
        return HexadecimalMessage.isHexadecimal(input);
    }

    private boolean isFraction(String input) {
        return FractionMessage.isFraction(input);
    }

    private boolean isString(String input) {
        return StringMessage.isString(input);
    }
}

package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessage;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageFactory {

    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");
    private static final String DIV_LIMITER = ":";

    public Message create(String message) throws BadRequestException {
        Type messageType = getType(message);

        switch (messageType) {
            case HEX:
                return new HexadecimalMessage(message);
            case FRACTION:
                return new FractionMessage(message);
            case STRING:
                return new StringMessage(message);
            default:
                throw new BadRequestException("message not supported");
        }
    }

    private Type getType(String content) {
        if(isHexadecimal(content)) return Type.HEX;
        if(isFraction(content)) return Type.FRACTION;
        if(isString(content)) return Type.STRING;

        return null;
    }

    private boolean isHexadecimal(String input) {
        final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
        return matcher.matches() && input.length() == 1 && ((int) input.charAt(0) >= (int) 'A' && (int) input.charAt(0) <= (int) 'F') ;
    }

    private boolean isFraction(String input) {
        if(!isContainsOnlyNumbersAndDivChars(input)) return false;
        int countDivLimmiter = StringUtils.countOccurrencesOf(input, DIV_LIMITER);
        String array[] = input.split(DIV_LIMITER);
        boolean isAllNumbers = Arrays.asList(array).stream().allMatch(str -> str.matches("-?\\d+(\\.\\d+)?"));

        return isAllNumbers && array.length - 1 == countDivLimmiter && countDivLimmiter >= 1;
    }

    public static boolean isContainsOnlyNumbersAndDivChars(String input) {
        String str = input.replaceAll(DIV_LIMITER,"");
        return  str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isString(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

}

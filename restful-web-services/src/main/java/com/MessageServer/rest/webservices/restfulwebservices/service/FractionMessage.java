package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class FractionMessage implements IMessageType {
    private static Message message;
    private int value;
    private static final String DIV_LIMITER = ":";

    public FractionMessage(Message message) {
        this.message = message;
    }

    @Override
    public Type getType() {
        return Type.FRACTION;
    }

    @Override
    public int convertByType() {
        String array[] = message.getContent().split(DIV_LIMITER);
        if(array.length == 0) return 0;
        this.value = Integer.parseInt(array[0]);

        for (int i = 1; i < array.length; i++) {
            this.value /= Integer.parseInt(array[i]);
        }

        return this.value;
    }


    public static boolean isFraction(String input) {
        if(!isContainsOnlyNumbersAndDivChars(input)) return false;
        int countDivLimmiter = StringUtils.countOccurrencesOf(input, DIV_LIMITER);
        String array[] = input.split(DIV_LIMITER);
        boolean isAllNumbers = Arrays.asList(array).stream().allMatch(str -> str.matches("-?\\d+(\\.\\d+)?"));

        return isAllNumbers && array.length - 1 == countDivLimmiter && countDivLimmiter >= 1;
    }

    @Override
    public boolean isPositive() {
        return convertByType() > 0;
    }

    public static boolean isContainsOnlyNumbersAndDivChars(String input) {
       String str = input.replaceAll(DIV_LIMITER,"");
       return  str.matches("-?\\d+(\\.\\d+)?");
    }
}

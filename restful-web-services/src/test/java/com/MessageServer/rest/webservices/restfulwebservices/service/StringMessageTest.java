package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.MessageFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringMessageTest {
    @Test
    @DisplayName("check positive input in String")
    void isPositive_checkInputIsPositive_success() throws Exception {
        Message message = new MessageFactory().create("123");
        assertTrue(message.isPositive());
    }

    @Test
    @DisplayName("check negative input in String")
    void isPositive_checkInputIsNegative_success() throws Exception {
        Message message = new MessageFactory().create("-123");
        assertTrue(!message.isPositive());
    }

    @Test
    @DisplayName("check conversion input in String")
    void isPositive_checkInputConversion_success() throws Exception {
        Message message = new MessageFactory().create("123");
        assertEquals(123, message.getValue());
    }
}

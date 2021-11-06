package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringMessageTest {
    @Test
    @DisplayName("check positive input in String")
    void isPositive_checkInputIsPositive_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("123"));
        assertTrue(messageType.isPositive());
    }

    @Test
    @DisplayName("check negative input in String")
    void isPositive_checkInputIsNegative_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("-125"));
        assertFalse(messageType.isPositive());
    }

    @Test
    @DisplayName("check conversion input in String")
    void isPositive_checkInputConversion_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("125"));
        assertEquals(125, messageType.convertByType());
    }
}

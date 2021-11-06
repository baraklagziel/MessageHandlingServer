//package com.MessageServer.rest.webservices.restfulwebservices.service;
//
//import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
//import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessage;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc
//public class FractionMessageTest {
//
//    @Test
//    @DisplayName("check positive input in Fraction")
//    void isPositive_checkInputIsPositive_success() throws Exception {
//        IMessage messageType = new TypeFactory().getMessageType(new Message("6:3"));
//        assertTrue(messageType.isPositive());
//    }
//
//    @Test
//    @DisplayName("check negative input in Fraction")
//    void isPositive_checkInputIsNegative_success() throws Exception {
//        IMessage messageType = new TypeFactory().getMessageType(new Message("-6:3"));
//        assertFalse(messageType.isPositive());
//    }
//
//    @Test
//    @DisplayName("check conversion input in Fraction")
//    void isPositive_checkInputConversion_success() throws Exception {
//        IMessage messageType = new TypeFactory().getMessageType(new Message("6:3"));
//        assertEquals(2, messageType.convertByType());
//    }
//}

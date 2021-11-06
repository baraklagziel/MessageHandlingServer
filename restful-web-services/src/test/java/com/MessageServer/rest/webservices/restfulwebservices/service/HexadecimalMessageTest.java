package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class HexadecimalMessageTest {
    @Test
    @DisplayName("check positive input in hex")
    void isPositive_checkInputIsPositive_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("F"));
        assertTrue(messageType.isPositive());
    }

    @Test
    @DisplayName("check conversion input in hex")
    void isPositive_checkInputConversion_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("F"));
        assertEquals(15, messageType.convertByType());
    }
}

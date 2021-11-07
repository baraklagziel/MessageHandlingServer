package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.MessageFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class MessageFactoryTest {

    @Test
    @DisplayName("check type Factory by Hex input")
    void getMessageType_checkCreateHexTypeInstance_success() throws Exception {
        Message message = new MessageFactory().create("F");
        assertSame(message.getType(), Type.HEX);
    }

    @Test
    @DisplayName("check type Factory by Fraction input")
    void getMessageType_checkCreateFractionTypeInstance_success() throws Exception {
        Message message = new MessageFactory().create("-6:3");
        assertSame(message.getType(), Type.FRACTION);
    }

    @Test
    @DisplayName("check type Factory by String input")
    void getMessageType_checkCreateStringTypeInstance_success() throws Exception {
        Message message = new MessageFactory().create("123");
        assertSame(message.getType(), Type.STRING);
    }
}

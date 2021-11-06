package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.Type;
import com.MessageServer.rest.webservices.restfulwebservices.validator.HttpRequest;
import com.MessageServer.rest.webservices.restfulwebservices.validator.LengthValidatorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class TypeFactoryTest {

    @Test
    @DisplayName("check type Factory by Hex input")
    void getMessageType_checkCreateHexTypeInstance_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("F"));
        assertSame(messageType.getType(), Type.HEX);
    }

    @Test
    @DisplayName("check type Factory by Fraction input")
    void getMessageType_checkCreateFractionTypeInstance_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("6:3"));
        assertSame(messageType.getType(), Type.FRACTION);
    }

    @Test
    @DisplayName("check type Factory by String input")
    void getMessageType_checkCreateStringTypeInstance_success() throws Exception {
        IMessageType messageType = new TypeFactory().getMessageType(new Message("5"));
        assertSame(messageType.getType(), Type.STRING);
    }
}

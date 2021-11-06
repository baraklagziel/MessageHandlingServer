package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.exception.EmptyMessageException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class LengthValidatorHandlerTest {

    @Test
    @DisplayName("validate non-empty input")
    void doHandle_validateNonEmptyInput_success() throws Exception {
        LengthValidatorHandler lengthValidatorHandler = new LengthValidatorHandler(null);

        boolean isValidLength = lengthValidatorHandler.doHandle(new HttpRequest(new Message("8")));

        assertTrue(isValidLength);
    }

    @Test
    @DisplayName("validate empty input")
    void doHandle_validateEmptyInput_error() throws Exception {
        LengthValidatorHandler lengthValidatorHandler = new LengthValidatorHandler(null);
        try {
            boolean isValidLength = lengthValidatorHandler.doHandle(new HttpRequest(new Message("")));
        }catch(EmptyMessageException error) {
            assertTrue(true);

        }
    }
}

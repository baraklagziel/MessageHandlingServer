//package com.MessageServer.rest.webservices.restfulwebservices.validator;
//
//import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
//import com.MessageServer.rest.webservices.restfulwebservices.exception.EmptyMessageException;
//import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureMockMvc
//public class PositiveValidatorHandlerTest {
//
//    @Test
//    @DisplayName("validate positive input")
//    void doHandle_validateNonEmptyInput_success() throws Exception {
//        LengthValidatorHandler lengthValidatorHandler = new LengthValidatorHandler(null);
//
//        boolean isValidLength = false;//lengthValidatorHandler.doHandle(new HttpRequest(new Message("8")));
//
//        assertTrue(isValidLength);
//    }
//
//    @Test
//    @DisplayName("validate negative input")
//    void doHandle_validateEmptyInput_error() throws Exception {
//        PositiveValidatorHandler positiveValidatorHandler  = new PositiveValidatorHandler(null);
//        try {
//            boolean isValidLength = positiveValidatorHandler.doHandle(new HttpRequest(new Message("-8")));
//        }catch(BadRequestException error) {
//            assertTrue(true);
//
//        }
//    }
//}

package com.MessageServer.rest.webservices.restfulwebservices.service.impl;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.model.MessageWrapper;
import com.MessageServer.rest.webservices.restfulwebservices.service.IMessageService;
import com.MessageServer.rest.webservices.restfulwebservices.validator.LengthValidatorHandler;
import com.MessageServer.rest.webservices.restfulwebservices.validator.PositiveValidatorHandler;
import com.MessageServer.rest.webservices.restfulwebservices.validator.Validator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class MessageService implements IMessageService {
    private List<Message> messages = new ArrayList<>();
    private Validator validator;

    private static String result;

    public String getResult() {
        return result;
    }

    public  void setResult(String result) {
        MessageService.result = result;
    }

    @Override
    public void sendMessage(String rawMessage) throws BadRequestException, JsonProcessingException {
        if (rawMessage == null || rawMessage.length() <= 0) {
            throw new BadRequestException("empty message");
        } else {
            Message messageObj = new MessageFactory().create(rawMessage);
            validateMessage(messageObj);
            sendMessageImpl(messageObj);
            this.messages.add(messageObj);
        }
    }

    private void sendMessageImpl(Message message) throws JsonProcessingException {
        HashMap<String, String> uriVariables = new HashMap<>();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(new MessageWrapper(message.getContent(), message.getValue()));
        uriVariables.put("messageKey", json);
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8183/queue-handler/{messageKey}", String.class, uriVariables);
        System.out.println(this.getResult());
    }

    private void validateMessage(Message httpRequest) {
        LengthValidatorHandler lengthValidationHandler = new LengthValidatorHandler(null);
        PositiveValidatorHandler positiveValidatorHandler = new PositiveValidatorHandler(lengthValidationHandler);
        Validator validator  = new Validator(positiveValidatorHandler);
        validator.validate(httpRequest);
    }
}

package com.MessageServer.rest.webservices.restfulwebservices.service.impl;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.model.MessageWrapper;
import com.MessageServer.rest.webservices.restfulwebservices.service.IMessageService;
import com.MessageServer.rest.webservices.restfulwebservices.validator.LengthValidatorHandler;
import com.MessageServer.rest.webservices.restfulwebservices.validator.PositiveValidatorHandler;
import com.MessageServer.rest.webservices.restfulwebservices.validator.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MessageService implements IMessageService {
    private List<Message> messages = new ArrayList<>();;
    private Validator validator;
    private static String value;

    @Override
    public String sendMessage(String rawMessage) throws BadRequestException {
        if (rawMessage == null || rawMessage.length() <= 0) {
            throw new BadRequestException("empty message");
        } else {
            Message messageObj = new MessageFactory().create(rawMessage);
            validateMessage(messageObj);
            String response = sendMessageImpl(messageObj);
            this.messages.add(messageObj);
            return response;
        }
    }

    private String sendMessageImpl(Message message) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("messageKey", message.getContent());
        uriVariables.put("messageValue", String.valueOf(message.getValue()));
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8182/message-handler/producer/{messageKey}/to/{messageValue}", String.class, uriVariables);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
        return entity.getBody();
    }

    private void validateMessage(Message httpRequest) {
        LengthValidatorHandler lengthValidationHandler = new LengthValidatorHandler(null);
        PositiveValidatorHandler positiveValidatorHandler = new PositiveValidatorHandler(lengthValidationHandler);
        Validator validator  = new Validator(positiveValidatorHandler);
        validator.validate(httpRequest);
    }
}

package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.model.MessageWrapper;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageService;
import com.MessageServer.rest.webservices.restfulwebservices.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Message sendMessage(String rawMessage) throws BadRequestException {
        if (rawMessage == null || rawMessage.length() <= 0) {
            throw new BadRequestException("empty message");
        } else {
            Message messageObj = new MessageFactory().create(rawMessage);
            validateMessage(messageObj);
            sendMessageImpl(messageObj);
            this.messages.add(messageObj);
            return messageObj;
        }
    }

    private void sendMessageImpl(Message message) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("messageKey", message.getContent());
        uriVariables.put("messageValue", String.valueOf(message.getValue()));
        MessageWrapper result = new RestTemplate().getForObject("http://localhost:8182/message-handler/producer/{messageKey}/to/{messageValue}", MessageWrapper.class, uriVariables);
        System.out.println(result.getMessageKey());
        System.out.println(result.getMessageValue());
    }

    private void validateMessage(Message httpRequest) {
//        LengthValidatorHandler lengthValidationHandler = new LengthValidatorHandler(null);
//        PositiveValidatorHandler positiveValidatorHandler = new PositiveValidatorHandler(lengthValidationHandler);
//        Validator validator  = new Validator(positiveValidatorHandler);
//        validator.validate(httpRequest);
    }
}

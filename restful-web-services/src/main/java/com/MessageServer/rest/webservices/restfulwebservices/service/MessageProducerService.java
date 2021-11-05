package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageService;
import com.MessageServer.rest.webservices.restfulwebservices.validator.HttpRequest;
import com.MessageServer.rest.webservices.restfulwebservices.validator.LengthValidatorHandler;
import com.MessageServer.rest.webservices.restfulwebservices.validator.PositiveValidatorHandler;
import com.MessageServer.rest.webservices.restfulwebservices.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class MessageProducerService implements IMessageService {
    private List<IMessageType> messages;
    private Validator validator;

    public MessageProducerService(Message message) {
        this.messages = new ArrayList<>();
        LengthValidatorHandler lengthValidationHandler = new LengthValidatorHandler(null);
        PositiveValidatorHandler positiveValidatorHandler = new PositiveValidatorHandler(lengthValidationHandler);
        Validator validator  = new Validator(positiveValidatorHandler);
        validator.validate(new HttpRequest(message));
        IMessageType messageType = new TypeFactory().getMessageType(message);
        this.messages.add(messageType);
    }


    @Override
    public Message getAllMessages() {
//        List<Message> messagesResults = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (IMessageType messageItem : messages) {
//            messagesResults.add(new Message(String.valueOf(messageItem.convertByType())));
            stringBuilder.append(String.valueOf(messageItem.convertByType()));
        }

        return new Message(stringBuilder.toString());
    }
}

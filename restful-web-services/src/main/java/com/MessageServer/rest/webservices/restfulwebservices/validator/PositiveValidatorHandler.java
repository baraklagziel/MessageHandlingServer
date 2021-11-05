package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.TypeFactory;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageType;

import java.util.regex.Pattern;

public class PositiveValidatorHandler extends Handler {
    public PositiveValidatorHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        IMessageType messageType = new TypeFactory().getMessageType(new Message(request.getMessage().getContent()));
        if (!messageType.isPositive()) throw new BadRequestException("input should always be positive integer");
        return true;
    }
}

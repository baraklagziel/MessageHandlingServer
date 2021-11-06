package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.MessageFactory;

public class PositiveValidatorHandler extends Handler {
    public PositiveValidatorHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(Message request) {
        Message messageType = new MessageFactory().create(request.getContent());
        if (!messageType.isPositive()) throw new BadRequestException("input should always be positive integer");
        return true;
    }
}

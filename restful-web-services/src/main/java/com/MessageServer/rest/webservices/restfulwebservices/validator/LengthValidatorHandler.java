package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.exception.EmptyMessageException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;

public class LengthValidatorHandler extends Handler  {
    public LengthValidatorHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(Message request) {
            if(request.getContent().length()  == 0) throw new EmptyMessageException("input can't be empty");
            return true;
        }
}

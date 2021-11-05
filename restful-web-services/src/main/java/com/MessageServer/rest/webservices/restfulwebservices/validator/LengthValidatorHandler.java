package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.exception.EmptyMessageException;

public class LengthValidatorHandler extends Handler  {
    public LengthValidatorHandler(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        try{
            if(request.getMessage().getContent().length()  == 0) throw new EmptyMessageException("input can't be empty");
            return true;
        }catch(EmptyMessageException error){
           return false;
        }
    }
}

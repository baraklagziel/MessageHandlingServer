package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;

public class Validator {
    private Handler handler;

    public Validator(Handler handler) {
        this.handler = handler;
    }

    public void validate(Message request) {
        handler.handle(request);
    }
}

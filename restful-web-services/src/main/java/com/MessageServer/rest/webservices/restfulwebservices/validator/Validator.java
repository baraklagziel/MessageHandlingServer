package com.MessageServer.rest.webservices.restfulwebservices.validator;

public class Validator {
    private Handler handler;

    public Validator(Handler handler) {
        this.handler = handler;
    }

    public void validate(HttpRequest request) {
        handler.handle(request);
    }
}

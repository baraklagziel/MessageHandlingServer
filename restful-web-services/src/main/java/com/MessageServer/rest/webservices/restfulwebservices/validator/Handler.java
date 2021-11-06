package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;

public abstract class Handler {
    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public void handle(Message request) {
        if(doHandle(request)) return;
        if(next != null)
            next.handle(request);

    }
    public abstract boolean doHandle(Message request);
}

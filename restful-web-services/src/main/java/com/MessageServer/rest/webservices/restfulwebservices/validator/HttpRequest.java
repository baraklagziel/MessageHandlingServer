package com.MessageServer.rest.webservices.restfulwebservices.validator;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;

public class HttpRequest {
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    private Message message;

    public HttpRequest(Message message) {
        this.message = message;
    }

}

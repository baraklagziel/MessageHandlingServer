package com.MessageServer.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyMessageException extends RuntimeException{
    public EmptyMessageException(String message) {
        super(message);
    }
}

package com.MessageServer.rest.webservices.restfulwebservices.service;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IMessageService {
//    Message getAllMessages();
    void sendMessage(String message) throws JsonProcessingException;
    String getResult();
    void setResult(String result);
}

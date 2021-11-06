package com.MessageServer.rest.webservices.restfulwebservices.service.impl;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;

import java.util.List;

public interface IMessageService {
//    Message getAllMessages();
    Message sendMessage(String message);
}

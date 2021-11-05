package com.MessageServer.rest.webservices.restfulwebservices.controller;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.MessageProducerService;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-handler")
public class MessageController {

    @GetMapping(value = "/{message}")
    @ResponseStatus(HttpStatus.OK)
    public Message handleMessage(@PathVariable String message) {
        Message messageItem = new Message(message);
        IMessageService messageService;
             messageService = new MessageProducerService(messageItem);

        return messageService.getAllMessages();
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String openScreen() {
        return "Welcome to Message Handling Server";
    }
}

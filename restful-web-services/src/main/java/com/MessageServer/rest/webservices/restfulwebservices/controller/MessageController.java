package com.MessageServer.rest.webservices.restfulwebservices.controller;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.model.MessageWrapper;
import com.MessageServer.rest.webservices.restfulwebservices.service.MessageProducerService;
import com.MessageServer.rest.webservices.restfulwebservices.service.impl.IMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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

    @GetMapping(value = "/sum/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String calculateSum(@PathVariable String message) {
        HashMap<String, String> uriVariables = new HashMap<>();
        Message messageItem = new Message(message);
        IMessageService messageService = new MessageProducerService(messageItem);
        uriVariables.put("messageKey", message);
        uriVariables.put("messageValue", messageService.getAllMessages().getContent());
        MessageWrapper messageObject = new RestTemplate().getForObject("http://localhost:8182/message-handler/producer/{messageKey}/to/{messageValue}", MessageWrapper.class, uriVariables);
        return "barak";
    }

}

package com.MessageServer.rest.webservices.restfulwebservices.controller;

import com.MessageServer.rest.webservices.restfulwebservices.model.Message;
import com.MessageServer.rest.webservices.restfulwebservices.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-handler")
public class MessageController {

    private IMessageService MessageService;

    @Autowired
    public MessageController(IMessageService IMessageService) {
        this.MessageService = IMessageService;
    }

    @GetMapping(value = "/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String handleMessage(@PathVariable String message) {
        return this.MessageService.sendMessage(message);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String openScreen() {
        return "Welcome to Message Handling Server";
    }

    @GetMapping(value = "/sum/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String calculateSum(@PathVariable String message) {

        return "barak";
    }

}

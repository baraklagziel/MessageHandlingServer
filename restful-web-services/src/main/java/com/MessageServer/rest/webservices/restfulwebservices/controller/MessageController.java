package com.MessageServer.rest.webservices.restfulwebservices.controller;

import com.MessageServer.rest.webservices.restfulwebservices.service.IMessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-handler")
public class MessageController {

    private IMessageService messageService;

    @Autowired
    public MessageController(IMessageService IMessageService) {
        this.messageService = IMessageService;
    }

    @GetMapping(value = "/{message}")
    @ResponseStatus(HttpStatus.OK)
    public void handleMessage(@PathVariable String message) throws JsonProcessingException {
        this.messageService.sendMessage(message);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String openScreen() {
        return "Welcome to Message Handling Server";
    }

    @GetMapping(value = "/sum/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String calculateSum(@PathVariable String message) throws JsonProcessingException {
        this.messageService.sendMessage(message);
        return this.messageService.getResult();
    }

    @PostMapping(value = "/result")
    @ResponseStatus(HttpStatus.OK)
    public String getResult(@RequestBody String result) {
        messageService.setResult(result);
        System.out.println("result: " + result);
        return result;
//        return "barak";
    }

}

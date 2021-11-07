package com.example.consumerservice.controllers;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.model.SumMessage;
import com.example.consumerservice.service.Context;
import com.example.consumerservice.service.MessageService;
import com.example.consumerservice.service.Printer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@RestController
@RequestMapping("/message-handler")
public class ConsumerController {
    public MessageService messageService;

    @Autowired
    public ConsumerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/producer/{message}")
    @ResponseStatus(HttpStatus.OK)
    public org.springframework.http.ResponseEntity<String> calculateSum(@PathVariable String message) throws JSONException, JsonProcessingException {
        JSONObject json = new JSONObject(message);
//        SumMessage messageItem = new SumMessage(json.get("messageKey").toString(), json.get("messageValue").toString());
        messageService.createMessage(json.get("messageKey").toString(), json.get("messageValue").toString());
        messageService.updateSum(messageService.getMessageValue());
        Context context = new Context(new Printer());
        context.executeStrategy(new Message(messageService.getMessageKey(), messageService.getSum()));
        SumMessage sumMessage1 = new SumMessage(messageService.getMessageKey(), String.valueOf(messageService.getSum()));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json1 = ow.writeValueAsString(sumMessage1);

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("messageKey", json1);

        ResponseEntity<String> result = new RestTemplate().postForEntity("http://localhost:8181/message-handler/result", json1, String.class);
        return org.springframework.http.ResponseEntity.ok().body(json1);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String calculateSum() {
        return "Welcome to Sum Message Handling Server";
    }

}

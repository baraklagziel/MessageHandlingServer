package com.example.consumerservice.controllers;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.ConsumerService;
import com.example.consumerservice.service.Context;
import com.example.consumerservice.service.Printer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-handler")
public class ConsumerController {

    private Object ResponseEntity;

    @GetMapping(value = "/producer/{messageKey}/to/{messageValue}")
    @ResponseStatus(HttpStatus.OK)
    public org.springframework.http.ResponseEntity<String> calculateSum(@PathVariable String messageKey, @PathVariable String messageValue) throws JsonProcessingException {
        ConsumerService consumerService = ConsumerService.getInstance();

        consumerService.updateSum(messageValue);

        Context context = new Context(new Printer());
        context.executeStrategy(new Message(messageKey,  consumerService.getSum()));

        SumMessage sumMessage = new SumMessage(messageKey, consumerService.getSum());
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println((objectMapper.writeValueAsString(sumMessage).toString()));
//        return new ResponseEntity(objectMapper.writeValueAsString(sumMessage) ,HttpStatus.OK);
       return  org.springframework.http.ResponseEntity.ok().body(sumMessage.toString());
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String calculateSum() {
        return "Welcome to Sum Message Handling Server";
    }


    class SumMessage {
        public String messageKey;
        public int sum;

         public SumMessage(String messageKey, int sum) {
             this.messageKey = messageKey;
             this.sum = sum;
         }

        @Override
        public String toString() {
            return "SumMessage{" +
                    "messageKey='" + messageKey + '\'' +
                    ", sum=" + sum +
                    '}';
        }
    }
}

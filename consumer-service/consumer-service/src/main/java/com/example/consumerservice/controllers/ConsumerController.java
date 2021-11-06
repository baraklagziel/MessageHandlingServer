package com.example.consumerservice.controllers;

import com.example.consumerservice.model.Message;
import com.example.consumerservice.service.ConsumerService;
import com.example.consumerservice.service.Context;
import com.example.consumerservice.service.Printer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-handler")
public class ConsumerController {

    @GetMapping(value = "/producer/{messageKey}/to/{messageValue}")
    @ResponseStatus(HttpStatus.OK)
    public SumMessage calculateSum(@PathVariable String messageKey,@PathVariable String messageValue) {
        ConsumerService consumerService = new ConsumerService();

        consumerService.updateSum(messageValue);

        Context context = new Context(new Printer());
        context.executeStrategy(new Message(messageKey, messageValue));

        SumMessage sumMessage = new SumMessage(messageKey, consumerService.getSum());
        int sum = 5;
        return new SumMessage(messageKey, sum);
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
     }
}

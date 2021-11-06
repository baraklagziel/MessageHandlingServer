package com.example.consumerservice.controllers;

import com.example.consumerservice.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message-handler")
public class ConsumerController {

    @GetMapping(value = "/producer/{messageKey}/to/{messageValue}")
    @ResponseStatus(HttpStatus.OK)
    public SumMessage calculateSum(@PathVariable String messageKey,@PathVariable String messageValue) {
        String sum = "5";
        return new SumMessage(messageKey, sum);
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String calculateSum() {
        return "Welcome to Sum Message Handling Server";
    }


    class SumMessage {
        public String messageKey;
        public String sum;

         public SumMessage(String messageKey, String sum) {
             this.messageKey = messageKey;
             this.sum = sum;
         }
     }
}

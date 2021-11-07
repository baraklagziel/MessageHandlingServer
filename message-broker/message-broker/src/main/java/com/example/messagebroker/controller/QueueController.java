package com.example.messagebroker.controller;

import com.example.messagebroker.services.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.lang.*;

@RestController
@RequestMapping("/queue-handler")
public class QueueController{

    private IQueueService queueService;

    @Autowired
    public QueueController(IQueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping(value = "/{message}")
    @ResponseStatus(value = HttpStatus.OK)
    public void handleMessage(@PathVariable String message) throws InterruptedException {
        queueService.startQueue(message);
    }

}

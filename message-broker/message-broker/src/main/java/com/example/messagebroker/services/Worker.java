package com.example.messagebroker.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    private static BlockingQueue<String> queue;
    public Worker(BlockingQueue<String> queueInstance) {
        queue = queueInstance;
    }

    public void run() {
        try {
                HashMap<String, String> uriVariables = new HashMap<>();
                uriVariables.put("messageKey", queue.take());
                ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8182/message-handler/producer/{messageKey}", String.class, uriVariables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
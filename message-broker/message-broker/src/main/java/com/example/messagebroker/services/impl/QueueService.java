package com.example.messagebroker.services.impl;

import com.example.messagebroker.services.IQueueService;
import com.example.messagebroker.services.Worker;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class QueueService implements IQueueService {
    private static BlockingQueue<String> queueInstance;

    public QueueService() throws InterruptedException {
        queueInstance = new LinkedBlockingQueue<String>(1024);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++){
            Thread.sleep(1000);
            executor.execute(new Worker(queueInstance));
        }

        executor.shutdown();

    }
    @Override
    public void startQueue(String message) throws InterruptedException {
        queueInstance.put(message);
    }
}

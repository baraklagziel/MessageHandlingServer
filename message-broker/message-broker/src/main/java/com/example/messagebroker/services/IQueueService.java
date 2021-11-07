package com.example.messagebroker.services;

public interface IQueueService {
    void startQueue(String message) throws InterruptedException;
}

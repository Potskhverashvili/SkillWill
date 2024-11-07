package com.example.Assignments34_Scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class IteratorService {
    private int number;

    @Async
    public void numberIteration() {
        for (int i = 0; i < 1000000; i++) {

            number++;
        }
        System.out.println("Final Number: " + number + "\n");
    }
}

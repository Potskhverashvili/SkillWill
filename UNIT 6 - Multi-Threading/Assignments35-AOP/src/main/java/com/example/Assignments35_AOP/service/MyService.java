package com.example.Assignments35_AOP.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Logger
    public void countEvenNumbers(int number) {
        int count = 0;
        for (int i = 0; i < number; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(number + " contain: " + count + " Even number");
    }
}

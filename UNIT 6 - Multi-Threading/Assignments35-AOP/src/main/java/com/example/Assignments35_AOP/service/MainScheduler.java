package com.example.Assignments35_AOP.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainScheduler {

    private final MyService myService;

    @Scheduled(fixedDelay = 1000)
    public void countEvenNumbers(){
        myService.countEvenNumbers(100);
    }
}

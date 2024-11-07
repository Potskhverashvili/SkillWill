package com.example.Assignments34_Scheduler;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MainService {

    private final IteratorService iteratorService;
    @Scheduled(fixedDelay = 1000)
    private void mainMethod(){
        System.out.println("Time Before: " + LocalDateTime.now());
        iteratorService.numberIteration();
        System.out.println("Time After: " + LocalDateTime.now());
    }
}

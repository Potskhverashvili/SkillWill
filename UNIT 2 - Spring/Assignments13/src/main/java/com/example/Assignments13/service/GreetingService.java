package com.example.Assignments13.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService  {

    public String getDefaultGreeting() {
        return "Hello";
    }

    public String getPersonalizedGreeting(String name) {
        return "Hello " + name;
    }
}

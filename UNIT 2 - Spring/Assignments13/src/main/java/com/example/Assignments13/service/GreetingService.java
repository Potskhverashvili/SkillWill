package com.example.Assignments13.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // Provides a "Hello World" greeting
    public String getHelloWorld() {
        return "Hello World!";
    }

    // Creates a personalized greeting with the given name
    public String getPersonalizedGreeting(String name) {
        return "Hello " + name;
    }
}

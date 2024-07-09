package com.example.Assignments13.controller;

import com.example.Assignments13.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    // A reference to the GreetingService (dependency injection)
    private  final GreetingService greetingService;

    // Constructor for dependency injection of GreetingService
    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Defines an endpoint for "/hello/world"
    @GetMapping(value = "/hello/world")
    public String greetings() {
        return greetingService.getHelloWorld();
    }

    // Defines an endpoint for "/hello/{name}" where {name} is a path variable
    @GetMapping(value = "/hello/{name}")
    public String greet(@PathVariable String name) {
        return greetingService.getPersonalizedGreeting(name);
    }
}

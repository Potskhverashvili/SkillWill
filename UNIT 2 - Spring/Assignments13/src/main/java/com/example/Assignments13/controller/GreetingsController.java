package com.example.Assignments13.controller;

import com.example.Assignments13.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    private  final GreetingService greetingService;

    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping(value = "/hello")
    public String greetings() {
        return greetingService.getDefaultGreeting();
    }

    @GetMapping(value = "/hello/{name}")
    public String greet(@PathVariable("name") String name) {
        return greetingService.getPersonalizedGreeting(name);
    }
}

package com.example.Assignments13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping(value = "/hello")
    public String greetings() {
        return "Hello";
    }

    @GetMapping(value = "/hello/{name}")
    public String greet(@PathVariable("name") String name) {
        return "Hello " + name;
    }
}

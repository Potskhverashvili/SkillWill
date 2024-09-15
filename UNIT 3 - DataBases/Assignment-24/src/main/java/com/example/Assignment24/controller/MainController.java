package com.example.Assignment24.controller;

import com.example.Assignment24.exceptions.MyRunTimeException;
import com.example.Assignment24.model.PersonRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/runtime-exception")
    public MyRunTimeException getRuntimeException () {
        throw new MyRunTimeException();
    }

    @PostMapping("register-person")
    public String registerPerson (@RequestBody @Valid PersonRequest person) {
        return "Person registered successfully";
    }
}

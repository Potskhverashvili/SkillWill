package com.example.Assignemt_31.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest userLoginRequest){
        return userService.login(userLoginRequest);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationRequest request){
        return userService.register(request);
    }

    @PostMapping("/hello")
    public String hello(){
        return "Success";
    }
}

package com.example.Assignement26.controller;

import com.example.Assignement26.clients.UserClient;
import com.example.Assignement26.response.userResponses.MultipleUserResponse;
import com.example.Assignement26.response.userResponses.SingleUserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserClient userClient;
    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/user/{id}")
    SingleUserResponse getUser(@PathVariable(name = "id") Integer id){
        return userClient.getUser(id);
    }

    @GetMapping("/users")
    MultipleUserResponse getUsersList(@RequestParam(name = "page", required = false) Integer page){
        return userClient.getUsersList(page);
    }

    @GetMapping("delay-response")
    MultipleUserResponse delayResponse(@RequestParam(name = "delay") Integer delay){
        return  userClient.delayResponse(delay);
    }
}

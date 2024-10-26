package com.example.Assignment_28.controller;

import com.example.Assignment_28.dto.UserRequest;
import com.example.Assignment_28.dto.UserResponse;
import com.example.Assignment_28.model.UserEntity;
import com.example.Assignment_28.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    // ---------- Create User -----------------
    @PostMapping("/create")
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

    // ---------- View All Added User --------------
    @GetMapping("/view-all")
    public List<UserEntity> viewAllUser(){
        return userService.viewAllUser();
    }
}

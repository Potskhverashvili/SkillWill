package com.example.Assignment_25.controller;

import com.example.Assignment_25.dto.userDto.UserRequest;
import com.example.Assignment_25.dto.userDto.UserResponse;
import com.example.Assignment_25.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{userId}")
    public  UserResponse getUser(@PathVariable("userId") Long id){
        return userService.getUser(id);
    }

}

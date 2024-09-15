package com.example.GroupWork5.controller;

import com.example.GroupWork5.DTO.userDto.UserRequest;
import com.example.GroupWork5.DTO.userDto.UserResponse;
import com.example.GroupWork5.Service.UserService;
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
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("/view")
    public UserResponse view(@RequestParam Long userId) {
        return userService.viewUser(userId);
    }
}

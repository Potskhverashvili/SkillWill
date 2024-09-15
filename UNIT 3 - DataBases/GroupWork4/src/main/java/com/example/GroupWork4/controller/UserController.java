package com.example.GroupWork4.controller;

import com.example.GroupWork4.Service.UserService;
import com.example.GroupWork4.model.Users;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --------- Register User ---------
    @PostMapping("/register-user")
    public String registerUser(@RequestBody @Valid Users user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    // -------- Update User ---------
    @PutMapping("/update-user")
    public Users updateUser(@RequestBody @Valid Users user) {
       return userService.updateUser(user);
        //return "User updated successfully";
    }

    // --------- Find User ------------
    @GetMapping("/find-all-user")
    public List<Users> findAllUser() {
        return userService.findAllUser();
    }
}

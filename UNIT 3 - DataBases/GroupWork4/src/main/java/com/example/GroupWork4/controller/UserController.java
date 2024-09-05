package com.example.GroupWork4.controller;

import com.example.GroupWork4.Service.UserService;
import com.example.GroupWork4.model.Users;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ----------- Register User ----------------
  /*  @PostMapping("/register-user")
    public Integer registerUser(@RequestParam String userName, String firstName, String lastName, String birthdate) {
        return userService.registerUser(userName, firstName, lastName, LocalDate.parse(birthdate));
    }*/

    @PostMapping("/register-user")
    public Integer registerUser(@RequestBody Users user) {
        return userService.registerUser(user);
    }


    // --------- Find User ------------

    @GetMapping("/find-all-user")
    public List<Users> findAllUser(){
        return userService.findAllUser();
    }
}

package com.example.GroupAssignment.controller;

import com.example.GroupAssignment.DTO.userDto.UserRequest;
import com.example.GroupAssignment.DTO.userDto.UserResponse;
import com.example.GroupAssignment.model.UserEntity;
import com.example.GroupAssignment.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // -------------------------- Constructor --------------------------
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // ------------------------- Methods -------------------------
    @PostMapping("/create")
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("/view-by-id")
    public UserResponse view(@RequestParam Long userId) {
        return userService.viewUser(userId);
    }

   @GetMapping("/view-all")
    public List<UserEntity> viewAllUser(){
        return userService.viewAllUser();
   }
}

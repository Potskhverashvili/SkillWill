package com.example.MyOwnVersion.controller;

import com.example.MyOwnVersion.dto.request.UserLoginRequest;
import com.example.MyOwnVersion.dto.request.UserRegistrationRequest;
import com.example.MyOwnVersion.dto.responce.UserResponse;
import com.example.MyOwnVersion.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserLoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserRegistrationRequest registrationRequest) {
        return userService.register(registrationRequest);
    }

    @PostMapping("/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> changeStatus(@RequestParam Long userId) {
        System.out.println("Status mapping");
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.activateOrDeactivateUser(userId));
    }

    @GetMapping("/view-all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> viewAllUser() {
        return userService.viewAllUser();
    }
}
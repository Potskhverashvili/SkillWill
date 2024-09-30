package com.example.GroupAssignment.service;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserClientInitialization {
    private final UserService userService;
    public UserClientInitialization(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.fetchAndSaveUsersFromApi();
    }
}

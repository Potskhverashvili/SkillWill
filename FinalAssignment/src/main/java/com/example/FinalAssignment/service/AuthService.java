package com.example.FinalAssignment.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthService {
    public static long getPrincipalDatabaseId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (long) authentication.getPrincipal();
    }
}

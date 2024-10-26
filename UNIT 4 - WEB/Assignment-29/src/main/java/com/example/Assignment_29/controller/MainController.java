package com.example.Assignment_29.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.boot.context.properties.bind.Bindable.listOf;

@RestController
public class MainController {

    @PostMapping("/login")
    public String login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            HttpServletRequest request
    ) {

        if (userName.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("isAuthenticated", Boolean.TRUE);
            session.setAttribute("userName", userName);
            session.setAttribute("role", "ADMIN");
            return userName + " Success";
        } else if (userName.equals("user1") && password.equals("user")) {
            HttpSession session = request.getSession();
            session.setAttribute("isAuthenticated", Boolean.TRUE);
            session.setAttribute("userName", userName);
            session.setAttribute("role", "USER");
            return userName + " Success";

        } else if (userName.equals("guest") && password.equals("guest")) {
            HttpSession session = request.getSession();
            session.setAttribute("isAuthenticated", Boolean.TRUE);
            session.setAttribute("userName", userName);
            session.setAttribute("role", "GUEST");
            return userName + " Success";
        }

        return "username or password is incorrect";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String role) {
        if (role.equalsIgnoreCase("ADMIN")) {
            return role;
        }

        return "Access Denied";
    }
}

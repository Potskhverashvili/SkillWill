package com.example.Assignment_29.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Qualifier("usernameAuthenticationFilter")
public class UsernameAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Session Object
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60);

        // Get isAuthenticated attribute
        Object isAuthenticated = session.getAttribute("isAuthenticated");

        // if is not authenticated
        if (isAuthenticated == null) {
            filterChain.doFilter(request, response);
        } else {
            Boolean authenticated = (Boolean) isAuthenticated;

            if (Boolean.TRUE.equals(isAuthenticated)) {

                // Create Custom Authentication
                CustomAuthentication authentication = new CustomAuthentication(
                        (String) session.getAttribute("role"),
                        (String) session.getAttribute("userName")
                );

                // Save Logged-in user in Security Context
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);

            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
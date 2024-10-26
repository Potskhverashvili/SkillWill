package com.example.Assignemt_31.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Qualifier("JwtBasedAuthenticationFilter")
public class JwtBasedAuthenticationFilter extends OncePerRequestFilter {

    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authenticationHolder = request.getHeader("authenticate");

        if(authenticationHolder == null || !authenticationHolder.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
        }

        assert authenticationHolder != null;
        String token = authenticationHolder.replace("Bearer ", "");
        Authentication authenticate = userService.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        filterChain.doFilter(request,response);
    }
}

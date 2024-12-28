package com.example.FinalAssignment.util;

import com.example.FinalAssignment.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("UserValidator")
@RequiredArgsConstructor
public class UserValidator {

    // ------------ check OwnerShip ----------------
    public boolean checkOwnerShip(Long userId) {
        return userId == AuthService.getPrincipalDatabaseId();
    }


    // --------------- Check Admin -------------------
    public boolean checkIfAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}

package com.example.Assignemt_31.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private static final String secret = "KEY-SECRET-KEY-1234565656565654";

    public String register(UserRegistrationRequest userRegistrationRequest) {
        MyUser myUser = UserMapper.mapToEntity(userRegistrationRequest);
        myUser.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        myUser.setRole("ROLE_USER");
        return userRepository.save(myUser).getUsername();
    }

    public String login(UserLoginRequest request) {
        MyUser myUser = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Username or password is invalid!"));

        Boolean matches = passwordEncoder.matches(request.getPassword(), myUser.getPassword());

        if (!matches) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Username or password is invalid!");
        }

        return Jwts.builder()
                .claim("userName", myUser.getUsername())
                .claim("role", myUser.getRole())
                .claim("firstName", myUser.getFirstName())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
    }


    public Authentication authenticate(String token) {
        Jws<Claims> claimsJws = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build().parseSignedClaims(token);

        Claims payload = claimsJws.getPayload();
        String userName = payload.get("userName", String.class);
        String role = payload.get("role", String.class);
        return new CustomAuthentication(role, userName);
    }
}

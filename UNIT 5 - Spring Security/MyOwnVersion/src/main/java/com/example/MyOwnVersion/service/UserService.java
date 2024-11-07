package com.example.MyOwnVersion.service;

import com.example.MyOwnVersion.dto.request.UserLoginRequest;
import com.example.MyOwnVersion.dto.request.UserRegistrationRequest;
import com.example.MyOwnVersion.dto.responce.UserResponse;
import com.example.MyOwnVersion.exception.CustomException;
import com.example.MyOwnVersion.exception.ErrorMessage;
import com.example.MyOwnVersion.mapper.userMapper.UserMapper;
import com.example.MyOwnVersion.model.UserEntity;
import com.example.MyOwnVersion.model.enums.Roles;
import com.example.MyOwnVersion.model.enums.Status;
import com.example.MyOwnVersion.repository.UserRepository;
import com.example.MyOwnVersion.security.CustomAuthentication;
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

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.MyOwnVersion.exception.ErrorMessage.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String secret = "VERY-SECRET-KEY1231113211111321133322";

    // -------------------------- Register ------------------------------------
    public String register(UserRegistrationRequest registrationRequest) {
        Optional<UserEntity> existingUser = userRepository.findUserByUserName(registrationRequest.getUsername());
        if (existingUser.isPresent())
            throw new CustomException(ErrorMessage.USER_ALREADY_EXIST);

        UserEntity user = UserMapper.mapRequestToEntity(registrationRequest);
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setRole(Roles.ROLE_USER);
        return userRepository.save(user).getUsername();
    }

    // ---------------------------- Log-in ------------------------------------
    public String login(UserLoginRequest loginRequest) {
        // check username if exist and correct
        UserEntity userLogin = userRepository.findUserByUserName(loginRequest.getUsername())
                .orElseThrow(() -> new CustomException(ErrorMessage.USERNAME_OR_PASSWORD_INCORRECT));

        /*UserEntity userLogin = userRepository.findUserByUserName(loginRequest.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Username or password is invalid!"));*/


        // Check Password
        if (!passwordEncoder.matches(loginRequest.getPassword(), userLogin.getPassword())) {
            throw new CustomException(ErrorMessage.USERNAME_OR_PASSWORD_INCORRECT);
        }

        // Check User Account Status
        if (userLogin.getStatus().equals(Status.DEACTIVATED)) {
            throw new CustomException(ErrorMessage.USER_ACCOUNT_INACTIVE);
        }

        // Generate JWT Token
        return Jwts.builder()
                .claim("username", userLogin.getUsername())
                .claim("id", userLogin.getId())
                .claim("role", userLogin.getRole())
                .claim("firstName", userLogin.getFirstName())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(Duration.ofHours(1))))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
    }

    // ------------------- Change User Status -----------------------
    public UserResponse activateOrDeactivateUser(Long userId) {
        // Check User if exist
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        // Check if the user is an admin
        if (user.getRole().equals(Roles.ROLE_ADMIN)) {
            // If the user is an admin, throw an exception as their role cannot be changed
            throw new CustomException(ErrorMessage.ADMIN_PROFILE_IMMUTABLE);
        } else {
            // If the user is not an admin, toggle their status
            user.setStatus(user.getStatus() == Status.ACTIVE ? Status.DEACTIVATED : Status.ACTIVE);
        }

        return UserMapper.mapEntitiesToResponse(userRepository.save(user));
    }


    // ---------------- View All User ----------------
    public List<UserResponse> viewAllUser() {
        List<UserResponse> allUser = UserMapper.mapEntitiesToResponseList(userRepository.findAll());
        if (allUser.isEmpty())
            throw new CustomException(ErrorMessage.USER_NOT_FOUND);
        return allUser;
    }


    // -------------------------------- Authentication Method ------------------------
    public Authentication authentication(String token) {
        Jws<Claims> claimsJws = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build()
                .parseSignedClaims(token);
        Claims payload = claimsJws.getPayload();
        String username = payload.get("username", String.class);
        String role = payload.get("role", String.class);
        long id = payload.get("id", Long.class);
        return new CustomAuthentication(role, username, id);
    }

    // ----------------- Helper Method  -----------------
    public UserEntity findUser(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new CustomException(ErrorMessage.USER_NOT_FOUND));
    }
}

package com.example.Assignment_25.service;

import com.example.Assignment_25.dto.userDto.UserRequest;
import com.example.Assignment_25.dto.userDto.UserResponse;
import com.example.Assignment_25.mappers.UserMapper;
import com.example.Assignment_25.model.UserEntity;
import com.example.Assignment_25.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // -------------------- Create User -------------------
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.mapRequestToEntity(userRequest);
        userEntity.setName(userRequest.getName());
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setBalance(userRequest.getBalance());
        UserEntity save = userRepository.save(userEntity);
        return UserMapper.mapEntityToResponse(save);
    }

    // -------------------- Find User ------------------
    public UserEntity findById(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public UserResponse getUser(Long id) {
        return UserMapper.mapEntityToResponse(findById(id));
    }
}

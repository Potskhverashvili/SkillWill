package com.example.Assignment_28.service;

import com.example.Assignment_28.dto.UserRequest;
import com.example.Assignment_28.dto.UserResponse;
import com.example.Assignment_28.mappers.UserMapper;
import com.example.Assignment_28.model.UserEntity;
import com.example.Assignment_28.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ------- Save User ----------
    public UserResponse saveUser(UserRequest userRequest) {
        UserEntity user = UserMapper.mapRequestToEntity(userRequest);
        UserEntity savedUser = userRepository.save(user);
        return UserMapper.mapEntityToResponse(savedUser);
    }

    // ------- View All --------
    public List<UserEntity> viewAllUser() {
        return userRepository.findAll();
    }
}

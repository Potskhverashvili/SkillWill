package com.example.GroupAssignment.service;

import com.example.GroupAssignment.DTO.userDto.UserRequest;
import com.example.GroupAssignment.DTO.userDto.UserResponse;
import com.example.GroupAssignment.mapper.userMapper.UserMapper;
import com.example.GroupAssignment.model.UserEntity;
import com.example.GroupAssignment.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ----------------- Create User ---------------
    public UserResponse createUser(UserRequest userRequest){
        UserEntity userEntity = UserMapper.mapRequestToEntity(userRequest);
        UserEntity save = userRepository.save(userEntity);
        return UserMapper.mapEntityToResponse(save);
    }

    // ----------------- View User -------------------
    public UserResponse viewUser(Long id){
        return UserMapper.mapEntityToResponse(findById(id));
    }

    // ---------------- View All User ----------------
    public List<UserEntity> viewAllUser(){
        return userRepository.findAll();
    }

    // ----------------- Helpers ------------------

    // -- Find By Id --
    public UserEntity findById(Long id){
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"/user/view/ - User not found"));
    }
}

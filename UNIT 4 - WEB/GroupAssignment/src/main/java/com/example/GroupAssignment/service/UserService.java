package com.example.GroupAssignment.service;

import com.example.GroupAssignment.DTO.userDto.UserRequest;
import com.example.GroupAssignment.DTO.userDto.UserResponse;
import com.example.GroupAssignment.exception.CustomException;
import com.example.GroupAssignment.mapper.userMapper.UserMapper;
import com.example.GroupAssignment.exception.ErrorMessage;
import com.example.GroupAssignment.model.UserEntity;
import com.example.GroupAssignment.repository.CommentRepository;
import com.example.GroupAssignment.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    public UserService(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    // ----------------- Create User ---------------
    public UserResponse createUser(UserRequest userRequest) {
        Optional<UserEntity> existingUser = userRepository.findUserByUserName(userRequest.getUserName());
        if (existingUser.isPresent())
            throw new CustomException(ErrorMessage.USER_ALREADY_EXIST);

        UserEntity userEntity = UserMapper.mapRequestToEntity(userRequest);
        UserEntity saveUser = userRepository.save(userEntity);
        return UserMapper.mapEntityToResponse(saveUser);
    }

    // ----------------- View User -------------------
    public UserResponse viewUser(Long id) {
        return UserMapper.mapEntityToResponse(checkUserIfExist(id));
    }

    // ---------------- View All User ----------------
    public List<UserEntity> viewAllUser() {
        List<UserEntity> allUser = userRepository.findAll();
        if (allUser.isEmpty())
            throw new CustomException(ErrorMessage.USER_NOT_FOUND);

        return allUser;
    }

    // ---------------- Delete User ----------------------
    public String deleteUser(Long id) {
        checkUserIfExist(id); // Check User if exist
        commentRepository.deleteCommentByUserId(id); // delete User's all Comment
        userRepository.deleteById(id);
        return "Deleted Successfully User with ID: " + id;
    }

    // ----------------- Helper Method  -----------------
    public UserEntity checkUserIfExist(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new CustomException(ErrorMessage.USER_NOT_FOUND));
    }

}

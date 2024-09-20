package com.example.GroupAssignment.mapper.userMapper;

import com.example.GroupAssignment.DTO.userDto.UserRequest;
import com.example.GroupAssignment.DTO.userDto.UserResponse;
import com.example.GroupAssignment.model.UserEntity;

public class UserMapper {

    // ------------------ Map to Entity --------------------
    public static UserEntity mapRequestToEntity(UserRequest userRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setName(userRequest.getName());
        userEntity.setSurname(userRequest.getSurname());
        userEntity.setBirthdate(userRequest.getBirthdate());

        return userEntity;
    }

    // ------------------ Entity to Response --------------------------
    public static UserResponse mapEntityToResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(userEntity.getId());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setName(userEntity.getName());
        userResponse.setSurname(userEntity.getSurname());
        userResponse.setBirthdate(userEntity.getBirthdate());

        return userResponse;
    }
}

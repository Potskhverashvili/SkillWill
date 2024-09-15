package com.example.Assignment_25.mappers;

import com.example.Assignment_25.dto.userDto.UserRequest;
import com.example.Assignment_25.dto.userDto.UserResponse;
import com.example.Assignment_25.model.UserEntity;

public class UserMapper {

    public static UserEntity mapRequestToEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setUserName(userRequest.getUserName());

        return userEntity;
    }

    public static UserResponse mapEntityToResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setName(userEntity.getName());
        userResponse.setBalance(userEntity.getBalance());
        userResponse.setUserName(userEntity.getUserName());

        return userResponse;
    }
}

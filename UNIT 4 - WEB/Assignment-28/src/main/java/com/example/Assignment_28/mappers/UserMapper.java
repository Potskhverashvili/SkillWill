package com.example.Assignment_28.mappers;

import com.example.Assignment_28.dto.UserRequest;
import com.example.Assignment_28.dto.UserResponse;
import com.example.Assignment_28.model.UserEntity;

public class UserMapper {

    public static UserEntity mapRequestToEntity(UserRequest userRequest) {
        return new UserEntity(userRequest.getUserName(), userRequest.getPassword());
    }


    public static UserResponse mapEntityToResponse(UserEntity userEntity){
        return new UserResponse(userEntity.getId(), userEntity.getUserName());
    }
}

package com.example.GroupWork5.mappers;

import com.example.GroupWork5.DTO.userDto.UserRequest;
import com.example.GroupWork5.DTO.userDto.UserResponse;
import com.example.GroupWork5.model.UserEntity;

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

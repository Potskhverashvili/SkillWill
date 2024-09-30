package com.example.GroupAssignment.mapper.userMapper;

import com.example.GroupAssignment.DTO.userDto.UserRequest;
import com.example.GroupAssignment.DTO.userDto.UserResponse;
import com.example.GroupAssignment.model.UserEntity;

public class UserMapper {

    // ------------------ Map to Entity --------------------
    public static UserEntity mapRequestToEntity(UserRequest userRequest) {
        return new UserEntity(
                userRequest.getUserName(),
                userRequest.getName(),
                userRequest.getSurname(),
                userRequest.getBirthdate()
        );
    }

    // ------------------ Entity to Response --------------------------
    public static UserResponse mapEntityToResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getBirthdate()
        );
    }
}

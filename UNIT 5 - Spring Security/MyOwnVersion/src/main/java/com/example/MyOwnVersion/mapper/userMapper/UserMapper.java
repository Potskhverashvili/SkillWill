package com.example.MyOwnVersion.mapper.userMapper;

import com.example.MyOwnVersion.dto.request.UserRegistrationRequest;
import com.example.MyOwnVersion.dto.responce.UserResponse;
import com.example.MyOwnVersion.model.UserEntity;

import java.util.List;

public class UserMapper {
    public static UserEntity mapRequestToEntity(UserRegistrationRequest registrationRequest) {
        UserEntity user = new UserEntity();
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setUsername(registrationRequest.getUsername());
        user.setDateOfBirth(registrationRequest.getDateOfBirth());
        return user;
    }


    // ------------------ Entity to Response --------------------------
    public static UserResponse mapEntitiesToResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getRole(),
                userEntity.getStatus()
        );
    }


    // ------------------ Entity to Response List --------------------------
    public static List<UserResponse> mapEntitiesToResponseList(List<UserEntity> allUser) {
        return (List<UserResponse>) allUser
                .stream()
                .map(userEntity -> {
                    return new UserResponse(
                            userEntity.getId(),
                            userEntity.getUsername(),
                            userEntity.getRole(),
                            userEntity.getStatus()
                    );

                }).toList();
    }
}

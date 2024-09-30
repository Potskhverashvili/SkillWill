package com.example.GroupAssignment.mapper.userClientMapper;

import com.example.GroupAssignment.DTO.userApiDto.UserApiResponse;
import com.example.GroupAssignment.model.UserEntity;

import java.util.List;

public class UserClientMapper {

    public static List<UserEntity> mapUserClientToUserEntity(UserApiResponse userApiResponse) {

        return userApiResponse.getData()
                .stream()
                .map(userData -> {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserName(userData.getEmail()); // Use Email as a userName
                    userEntity.setName(userData.getFirstName());
                    userEntity.setSurname(userData.getLastName());
                    return userEntity;
                })
                .toList();
    }
}

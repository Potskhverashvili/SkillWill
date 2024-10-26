package com.example.Assignemt_31.mapper;


public class UserMapper {

    public static MyUser mapToEntity(UserRegistrationRequest request) {

        MyUser myUser = new MyUser();

        myUser.setFirstName(request.getFirstName());
        myUser.setLastName(request.getLastName());
        myUser.setUsername(request.getUsername());
        return myUser;

    }
}

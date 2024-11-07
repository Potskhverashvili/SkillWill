package com.example.MyOwnVersion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequest {
    @NotBlank(message = "username can't be blank" )
    private  String username;

    @NotBlank(message = "password can't be blank")
    private  String password;
}

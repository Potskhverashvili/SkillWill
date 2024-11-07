package com.example.MyOwnVersion.dto.responce;

import com.example.MyOwnVersion.model.enums.Roles;
import com.example.MyOwnVersion.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private long Id;
    private String username;
    private Roles role;
    private Status status;
}

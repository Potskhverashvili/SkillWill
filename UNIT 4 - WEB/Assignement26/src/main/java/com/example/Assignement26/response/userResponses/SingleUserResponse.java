package com.example.Assignement26.response.userResponses;

import com.example.Assignement26.models.Support;
import com.example.Assignement26.models.User;
import lombok.Data;

@Data
public class SingleUserResponse {
    private User data;
    private Support support;
}

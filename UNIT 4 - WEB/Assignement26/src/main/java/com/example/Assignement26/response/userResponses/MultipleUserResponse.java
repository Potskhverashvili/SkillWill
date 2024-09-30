package com.example.Assignement26.response.userResponses;

import com.example.Assignement26.models.PageInfo;
import com.example.Assignement26.models.Support;
import com.example.Assignement26.models.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MultipleUserResponse extends PageInfo {
    private List<User> data;
    private Support support;
}

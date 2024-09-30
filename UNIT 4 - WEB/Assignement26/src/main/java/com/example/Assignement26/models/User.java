package com.example.Assignement26.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String email;

    @JsonProperty("first_name")
    private String firsName;
    @JsonProperty("last_name")

    private String lastName;
    private String avatar;
}

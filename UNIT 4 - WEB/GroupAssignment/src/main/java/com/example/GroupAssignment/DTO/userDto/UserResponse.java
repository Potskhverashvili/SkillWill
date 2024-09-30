package com.example.GroupAssignment.DTO.userDto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String userName;
    private String name;
    private String surname;
    private LocalDate birthdate;
}

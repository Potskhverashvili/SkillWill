package com.example.GroupAssignment.DTO.comentDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    @NotNull(message = "comment can not be null")
    @Size(min = 2, max = 128, message = "comment must between in 2-128")
    private String comment;
}

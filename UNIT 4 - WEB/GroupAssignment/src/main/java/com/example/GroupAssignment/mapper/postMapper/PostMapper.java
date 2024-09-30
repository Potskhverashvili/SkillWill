package com.example.GroupAssignment.mapper.postMapper;

import com.example.GroupAssignment.DTO.postDto.PostRequest;
import com.example.GroupAssignment.DTO.postDto.PostResponse;
import com.example.GroupAssignment.model.PostEntity;

public class PostMapper {
    // ------------------ Request to Entity --------------------
    public static PostEntity mapRequestToEntity(PostRequest postRequest) {

        PostEntity postEntity = new PostEntity();
        postEntity.setText(postRequest.getText());
        return postEntity;
    }

    // ------------------ Entity to Response ------------------
    public static PostResponse mapEntityToResponse(PostEntity postEntity) {
        return new PostResponse(
                postEntity.getId(),
                postEntity.getText()
        );
    }
}

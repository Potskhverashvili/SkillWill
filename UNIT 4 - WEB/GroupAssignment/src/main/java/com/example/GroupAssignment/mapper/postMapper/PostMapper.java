package com.example.GroupAssignment.mapper.postMapper;

import com.example.GroupAssignment.DTO.postDto.PostRequest;
import com.example.GroupAssignment.DTO.postDto.PostResponse;
import com.example.GroupAssignment.model.PostEntity;

public class PostMapper {

    // ------------------ Map to Entity --------------------
    public static PostEntity mapRequestToEntity(PostRequest postRequest) {
        PostEntity postEntity = new PostEntity();
        postEntity.setText(postRequest.getText());
        return postEntity;
    }


    // ------------------ Entity to Response ------------------
    public static PostResponse mapEntityToResponse(PostEntity postEntity) {
        PostResponse postResponse = new PostResponse();
        postResponse.setId(postEntity.getId());
        postResponse.setText(postEntity.getText());
        return postResponse;
    }
}

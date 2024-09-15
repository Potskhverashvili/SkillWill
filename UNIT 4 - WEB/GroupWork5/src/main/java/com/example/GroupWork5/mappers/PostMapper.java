package com.example.GroupWork5.mappers;

import com.example.GroupWork5.DTO.postDto.PostRequest;
import com.example.GroupWork5.DTO.postDto.PostResponse;
import com.example.GroupWork5.model.PostEntity;

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

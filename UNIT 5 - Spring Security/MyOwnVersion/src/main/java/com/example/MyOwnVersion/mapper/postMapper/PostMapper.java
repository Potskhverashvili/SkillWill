package com.example.MyOwnVersion.mapper.postMapper;

import com.example.MyOwnVersion.dto.request.PostRequest;
import com.example.MyOwnVersion.dto.responce.PostResponse;
import com.example.MyOwnVersion.model.PostEntity;

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

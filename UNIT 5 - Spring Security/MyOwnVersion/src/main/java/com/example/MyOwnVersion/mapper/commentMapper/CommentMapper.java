package com.example.MyOwnVersion.mapper.commentMapper;

import com.example.MyOwnVersion.dto.request.CommentRequest;
import com.example.MyOwnVersion.dto.responce.CommentResponse;
import com.example.MyOwnVersion.model.CommentEntity;

public class CommentMapper {

    // ------------------ Map to Entity --------------------
    public static CommentEntity mapRequestToEntity(CommentRequest commentRequest) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(commentRequest.getComment());
        return commentEntity;
    }


    // ------------------ Entity to Response ----------------
    public static CommentResponse mapEntityToResponse(CommentEntity commentEntity) {
        return new CommentResponse(
                commentEntity.getId(),
                commentEntity.getComment(),
                commentEntity.getUserEntity().getId(),
                commentEntity.getPostEntity().getId()
        );
    }
}


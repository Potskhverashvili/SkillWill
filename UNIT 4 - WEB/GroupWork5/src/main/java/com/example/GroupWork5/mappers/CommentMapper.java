package com.example.GroupWork5.mappers;

import com.example.GroupWork5.DTO.commentDto.CommentRequest;
import com.example.GroupWork5.DTO.commentDto.CommentResponse;
import com.example.GroupWork5.model.CommentEntity;

public class CommentMapper {

    // ------------------ Map to Entity --------------------
    public static CommentEntity mapRequestToEntity(CommentRequest commentRequest) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(commentRequest.getComment());
        return commentEntity;
    }


    // ------------------ Entity to Response ----------------
    public static CommentResponse mapEntityToResponse(CommentEntity commentEntity) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(commentEntity.getId());
        commentResponse.setComment(commentEntity.getComment());
        return commentResponse;
    }
}

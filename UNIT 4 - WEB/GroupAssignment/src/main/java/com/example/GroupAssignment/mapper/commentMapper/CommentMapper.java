package com.example.GroupAssignment.mapper.commentMapper;

import com.example.GroupAssignment.DTO.comentDto.CommentRequest;
import com.example.GroupAssignment.DTO.comentDto.CommentResponse;
import com.example.GroupAssignment.model.CommentEntity;

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
        commentResponse.setForPostId(commentEntity.getId());
        return commentResponse;
    }
}

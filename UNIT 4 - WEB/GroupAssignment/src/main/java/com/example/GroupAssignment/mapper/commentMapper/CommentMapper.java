package com.example.GroupAssignment.mapper.commentMapper;

import com.example.GroupAssignment.DTO.commentDto.CommentRequest;
import com.example.GroupAssignment.DTO.commentDto.CommentResponse;
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
        return new CommentResponse(
                commentEntity.getId(),
                commentEntity.getComment(),
                commentEntity.getUserEntity().getId(),
                commentEntity.getPostEntity().getId()
        );
    }
}

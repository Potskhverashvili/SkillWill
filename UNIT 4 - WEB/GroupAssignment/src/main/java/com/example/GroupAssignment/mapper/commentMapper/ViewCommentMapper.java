package com.example.GroupAssignment.mapper.commentMapper;


import com.example.GroupAssignment.DTO.commentDto.ViewComment;
import com.example.GroupAssignment.model.CommentEntity;

public class ViewCommentMapper {

    public static ViewComment mapCommentEntityToView(CommentEntity commentEntity) {
        return new ViewComment(
                commentEntity.getId(),
                commentEntity.getComment(),
                commentEntity.getUserEntity().getId(),
                commentEntity.getPostEntity().getId()
        );
    }
}

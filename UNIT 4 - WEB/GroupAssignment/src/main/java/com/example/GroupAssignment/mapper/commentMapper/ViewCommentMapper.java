package com.example.GroupAssignment.mapper.commentMapper;


import com.example.GroupAssignment.DTO.comentDto.ViewComment;
import com.example.GroupAssignment.model.CommentEntity;

public class ViewCommentMapper {

    public static ViewComment mapEntityToView(CommentEntity commentEntity) {
        ViewComment viewComment = new ViewComment();
        //-- Set Comment --
        viewComment.setCommentId(commentEntity.getId());
        viewComment.setComment(commentEntity.getComment());
        //-- set Post id and Post Owner id  --
        viewComment.setForPostId(commentEntity.getId());
        viewComment.setOwnerUserId(commentEntity.getId());
        return viewComment;
    }
}

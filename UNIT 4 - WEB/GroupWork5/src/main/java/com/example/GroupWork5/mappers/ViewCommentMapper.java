package com.example.GroupWork5.mappers;

import com.example.GroupWork5.DTO.commentDto.ViewComment;
import com.example.GroupWork5.model.CommentEntity;

public class ViewCommentMapper {

    public static ViewComment mapEntityToView(CommentEntity commentEntity) {
        ViewComment viewComment = new ViewComment();
        //-- Set Comment --
        viewComment.setCommentId(commentEntity.getId());
        viewComment.setComment(commentEntity.getComment());
        //-- set Post id and Post Owner id  --
        viewComment.setForPostId(commentEntity.getPostId());
        viewComment.setOwnerUserId(commentEntity.getOwnerId());
        return viewComment;
    }
}

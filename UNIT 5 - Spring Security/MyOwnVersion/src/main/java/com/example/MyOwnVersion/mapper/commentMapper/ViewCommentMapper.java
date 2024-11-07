package com.example.MyOwnVersion.mapper.commentMapper;

import com.example.MyOwnVersion.dto.view.ViewComment;
import com.example.MyOwnVersion.model.CommentEntity;

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
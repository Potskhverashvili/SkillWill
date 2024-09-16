package com.example.GroupWork5.mappers;

import com.example.GroupWork5.DTO.postDto.ViewPost;
import com.example.GroupWork5.model.PostEntity;

public class ViewPostMapper {

    public static ViewPost mapEntityToView(PostEntity postEntity){
        ViewPost viewPost = new ViewPost();
        viewPost.setId(postEntity.getId());
        viewPost.setText(postEntity.getText());
        viewPost.setOwnerUserId(postEntity.getUserId());
        return viewPost;
    }
}

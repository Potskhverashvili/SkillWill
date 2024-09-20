package com.example.GroupAssignment.mapper.postMapper;

import com.example.GroupAssignment.DTO.postDto.ViewPost;
import com.example.GroupAssignment.model.PostEntity;

public class ViewPostMapper {

    public static ViewPost mapEntityToView(PostEntity postEntity){
        ViewPost viewPost = new ViewPost();
        viewPost.setId(postEntity.getId());
        viewPost.setText(postEntity.getText());
        viewPost.setOwnerUserId(postEntity.getId());
        return viewPost;
    }
}

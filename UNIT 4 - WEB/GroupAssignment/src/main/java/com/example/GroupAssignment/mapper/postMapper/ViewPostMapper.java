package com.example.GroupAssignment.mapper.postMapper;

import com.example.GroupAssignment.DTO.postDto.ViewPost;
import com.example.GroupAssignment.model.PostEntity;

public class ViewPostMapper {
    public static ViewPost mapPostEntityToView(PostEntity postEntity){
        return new ViewPost(postEntity.getId(), postEntity.getText(),postEntity.getUserEntity().getId());
    }
}

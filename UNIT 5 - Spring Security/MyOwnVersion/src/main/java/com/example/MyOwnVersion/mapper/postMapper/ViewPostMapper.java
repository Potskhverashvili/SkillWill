package com.example.MyOwnVersion.mapper.postMapper;

import com.example.MyOwnVersion.dto.view.ViewPost;
import com.example.MyOwnVersion.model.PostEntity;

public class ViewPostMapper {
    public static ViewPost mapPostEntityToView(PostEntity postEntity){
        return new ViewPost(postEntity.getId(), postEntity.getText(),postEntity.getUserEntity().getId());
    }
}
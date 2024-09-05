package com.example.GroupWork4.controller;

import com.example.GroupWork4.Service.PostService;
import com.example.GroupWork4.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

}

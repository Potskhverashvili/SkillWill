package com.example.GroupWork5.controller;

import com.example.GroupWork5.DTO.postDto.PostRequest;
import com.example.GroupWork5.DTO.postDto.PostResponse;
import com.example.GroupWork5.DTO.postDto.ViewPost;
import com.example.GroupWork5.Service.PostService;
import com.example.GroupWork5.model.PostEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public PostResponse createPost(@RequestParam("userId") Long userId,@RequestBody @Valid PostRequest postRequest){
        return postService.createPost(userId, postRequest);
    }

    @GetMapping("/view-concrete")
    public ViewPost viewConcretePost(@RequestParam Long postId){
        return postService.viewConcretePost(postId);
    }

    @GetMapping("/all-of-user")
    public List<ViewPost> findAllPostOfUser(
            @RequestParam("userId") Long userId,
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return postService.findAllPostOfUser(userId,size,page).getContent();
    }

    @GetMapping("/view-all")
    public List<ViewPost> findAllPost(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
            ){
        return postService.findAllPost(size, page).getContent();
    }
}

/*
package com.example.GroupAssignment.controller;

import com.example.GroupAssignment.DTO.postDto.PostRequest;
import com.example.GroupAssignment.DTO.postDto.PostResponse;
import com.example.GroupAssignment.DTO.postDto.ViewPost;
import com.example.GroupAssignment.service.PostService;
import jakarta.validation.Valid;
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
    public PostResponse createPost(@RequestParam("userId") Long userId, @RequestBody @Valid PostRequest postRequest) {
        return postService.createPost(userId, postRequest);
    }

    @GetMapping("/view-concrete")
    public ViewPost viewConcretePost(@RequestParam Long postId) {
        return postService.viewConcretePost(postId);
    }

    @GetMapping("/all-of-user")
    public List<ViewPost> findAllPostOfUser(
            @RequestParam("userId") Long userId,
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return postService.findAllPostOfUser(userId, size, page).getContent();
    }

    @GetMapping("/view-all")
    public List<ViewPost> findAllPost(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return postService.findAllPost(size, page).getContent();
    }

    @PutMapping("/update")
    public PostResponse updatePost(
            @RequestParam("userId") Long userId,
            @RequestParam("postId") Long postId,
            @RequestParam("updateText") String text
    ) {
        return postService.updatePost(userId, postId, text);
    }

    @DeleteMapping("/delete")
    public String deletePost(
            @RequestParam("userId") Long userId,
            @RequestParam("postId") Long postId
    ) {
        return postService.deletePost(userId,postId);
    }
}
*/

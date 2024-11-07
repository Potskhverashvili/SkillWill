package com.example.MyOwnVersion.controller;

import com.example.MyOwnVersion.dto.request.PostRequest;
import com.example.MyOwnVersion.dto.responce.PostResponse;
import com.example.MyOwnVersion.dto.view.ViewPost;
import com.example.MyOwnVersion.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/create-post")
    public ResponseEntity<PostResponse> createPost(@RequestBody @Valid PostRequest postRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postRequest));
    }

    @GetMapping("/view-concrete-post")
    public ViewPost viewConcretePost(@RequestParam Long postId) {
        return postService.viewConcretePost(postId);
    }

    @GetMapping("/all-of-user-post")
    public List<ViewPost> findAllPostOfUser(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        System.out.println("all");
        return postService.findAllPostOfUser(size, page).getContent();
    }

    @GetMapping("/view-all-post")
    public List<ViewPost> findAllPost(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return postService.findAllPost(size, page).getContent();
    }

    @PutMapping("/update-post")
    public PostResponse updatePost(
            @RequestParam("postId") Long postId,
            @RequestBody @Valid PostRequest postRequest
    ) {
        return postService.updatePost(postId, postRequest);
    }

    @DeleteMapping("/delete-post")
    public String deletePost(
            @RequestParam("postId") Long postId
    ) {
        return postService.deletePost(postId);
    }
}

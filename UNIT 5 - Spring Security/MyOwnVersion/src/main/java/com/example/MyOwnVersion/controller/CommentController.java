package com.example.MyOwnVersion.controller;

import com.example.MyOwnVersion.dto.request.CommentRequest;
import com.example.MyOwnVersion.dto.responce.CommentResponse;
import com.example.MyOwnVersion.dto.view.ViewComment;
import com.example.MyOwnVersion.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create-comment")
    public CommentResponse createComment(
            @RequestParam Long postId,
            @RequestBody @Valid CommentRequest commentRequest
    ) {

        return commentService.createComment(postId, commentRequest);
    }

    @GetMapping("/view-all-comment")
    public List<ViewComment> viewAllComment(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return commentService.viewAllComment(size, page).getContent();
    }

    @PutMapping("/update-comment")
    public CommentResponse updateComment(
            @RequestParam("commentId") Long commentId,
            @RequestBody @Valid CommentRequest commentRequest
    ) {
        return commentService.updateComment(commentId, commentRequest);
    }

    @DeleteMapping("/delete-comment")
    public String deleteComment(
            @RequestParam("commentId") Long commentId
    ) {
        return commentService.deleteComment(commentId);
    }
}

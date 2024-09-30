package com.example.GroupAssignment.controller;

import com.example.GroupAssignment.DTO.commentDto.CommentRequest;
import com.example.GroupAssignment.DTO.commentDto.CommentResponse;
import com.example.GroupAssignment.DTO.commentDto.ViewComment;
import com.example.GroupAssignment.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public CommentResponse createComment(
            @RequestParam Long postId, Long userId,
            @RequestBody @Valid CommentRequest commentRequest
    ) {
        return commentService.createComment(userId, postId, commentRequest);
    }

    @GetMapping("/view-all")
    public List<ViewComment> viewAllComment(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return commentService.viewAllComment(size, page).getContent();
    }

    @PutMapping("/update")
    public CommentResponse updateComment(
            @RequestParam("userId") Long userId,
            @RequestParam("commentId") Long commentId,
            @RequestParam("updateText") String text
    ) {
        return commentService.updateComment(userId, commentId, text);
    }

    @DeleteMapping("/delete")
    public String deleteComment(
            @RequestParam("userId") Long userId,
            @RequestParam("commentId") Long commentId
    ) {
        return commentService.deleteComment(userId, commentId);
    }
}

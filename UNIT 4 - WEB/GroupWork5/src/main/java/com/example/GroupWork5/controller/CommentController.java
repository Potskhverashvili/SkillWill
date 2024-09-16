package com.example.GroupWork5.controller;

import com.example.GroupWork5.DTO.commentDto.CommentRequest;
import com.example.GroupWork5.DTO.commentDto.CommentResponse;

import com.example.GroupWork5.DTO.commentDto.ViewComment;
import com.example.GroupWork5.Service.CommentService;
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
            @RequestParam Long postId,
            @RequestBody @Valid CommentRequest commentRequest
    ) {
        return commentService.createComment(postId, commentRequest);
    }

    @GetMapping("/view-all")
    public List<ViewComment> viewAllComment(
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return commentService.findAllComment(size, page).getContent();
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

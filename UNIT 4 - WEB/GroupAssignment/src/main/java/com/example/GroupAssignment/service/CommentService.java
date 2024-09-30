package com.example.GroupAssignment.service;

import com.example.GroupAssignment.DTO.commentDto.CommentRequest;
import com.example.GroupAssignment.DTO.commentDto.CommentResponse;
import com.example.GroupAssignment.DTO.commentDto.ViewComment;
import com.example.GroupAssignment.exception.CustomException;
import com.example.GroupAssignment.mapper.commentMapper.CommentMapper;
import com.example.GroupAssignment.model.CommentEntity;
import com.example.GroupAssignment.exception.ErrorMessage;
import com.example.GroupAssignment.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService, UserService userService1) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService1;
    }

    // ------------------------------- Create -------------------------------
    public CommentResponse createComment(Long userId, Long postId, CommentRequest commentRequest) {
        CommentEntity comment = CommentMapper.mapRequestToEntity(commentRequest);
        comment.setUserEntity(userService.checkUserIfExist(userId));
        comment.setPostEntity(postService.checkPostIfExist(postId));
        CommentEntity saveComment = commentRepository.save(comment);
        return CommentMapper.mapEntityToResponse(saveComment);
    }


    // ------------------------------- View All Post -----------------------------
    public Page<ViewComment> viewAllComment(Integer size, Integer page) {
        Page<ViewComment> allComment = commentRepository
                .findAllComment(
                        PageRequest.of(size, page, Sort.Direction.ASC, "id")
                );
        if (allComment.isEmpty())
            throw new CustomException(ErrorMessage.COMMENT_NOT_FOUND);

        return allComment;
    }

    // ------------------------------ Update Comment -------------------------------

    public CommentResponse updateComment(Long ownerId, Long commentId, String updateText) {

        CommentEntity commentToUpdate = checkCommentIfExist(commentId);

        if (!commentToUpdate.getUserEntity().getId().equals(ownerId))
            throw new CustomException(ErrorMessage.NOT_ALLOWED);

        commentToUpdate.setComment(updateText); // Update the post text
        commentRepository.save(commentToUpdate); // Save the updated text to the database

        return CommentMapper.mapEntityToResponse(commentToUpdate);
    }

    // ------------------------------ Delete Comment ------------------------------
    public String deleteComment(Long ownerId, Long commentId) {
        CommentEntity commentToDelete = checkCommentIfExist(commentId);

        if (!commentToDelete.getUserEntity().getId().equals(ownerId))
            throw new CustomException(ErrorMessage.NOT_ALLOWED);

        commentRepository.deleteById(commentId);
        return "Deleted Successfully Comment with ID: " + commentId;
    }

    // ------------------------------ Helper Method ------------------------------
    public CommentEntity checkCommentIfExist(Long postId) {
        Optional<CommentEntity> postById = commentRepository.findById(postId);
        return postById.orElseThrow(() -> new CustomException(ErrorMessage.COMMENT_NOT_FOUND));
    }
}

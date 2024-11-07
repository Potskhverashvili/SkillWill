package com.example.MyOwnVersion.service;

import com.example.MyOwnVersion.dto.request.CommentRequest;
import com.example.MyOwnVersion.dto.responce.CommentResponse;
import com.example.MyOwnVersion.dto.view.ViewComment;
import com.example.MyOwnVersion.exception.CustomException;
import com.example.MyOwnVersion.exception.ErrorMessage;
import com.example.MyOwnVersion.mapper.commentMapper.CommentMapper;
import com.example.MyOwnVersion.model.CommentEntity;
import com.example.MyOwnVersion.model.enums.Roles;
import com.example.MyOwnVersion.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public CommentResponse createComment(Long postId, CommentRequest commentRequest) {
        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        CommentEntity comment = CommentMapper.mapRequestToEntity(commentRequest);
        comment.setUserEntity(userService.findUser(principal));

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

    public CommentResponse updateComment(Long commentId, CommentRequest commentRequest) {
        CommentEntity commentToUpdate = checkCommentIfExist(commentId);

        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        Roles isAdmin = userService.findUser(principal).getRole();

        // Check is owned by the user or isAdmin
        if (commentToUpdate.getUserEntity().getId().equals(principal) || isAdmin.equals(Roles.ROLE_ADMIN)) {
            commentToUpdate.setComment(commentRequest.getComment()); // Update the post text
            commentRepository.save(commentToUpdate); // Save the updated text to the database
        } else {
            throw new CustomException(ErrorMessage.NOT_ALLOWED);
        }

        return CommentMapper.mapEntityToResponse(commentToUpdate);
    }

    // ------------------------------ Delete Comment ------------------------------
    public String deleteComment(Long commentId) {
        CommentEntity commentToDelete = checkCommentIfExist(commentId);

        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        Roles isAdmin = userService.findUser(principal).getRole();

        // Check is owned by the user or isAdmin
        if (commentToDelete.getUserEntity().getId().equals(principal) || isAdmin.equals(Roles.ROLE_ADMIN)) {
            commentRepository.deleteById(commentId);

        } else {
            throw new CustomException(ErrorMessage.NOT_ALLOWED);
        }

        return "Deleted Successfully Comment with ID: " + commentId;
    }

    // ------------------------------ Helper Method ------------------------------
    public CommentEntity checkCommentIfExist(Long postId) {
        Optional<CommentEntity> postById = commentRepository.findById(postId);
        return postById.orElseThrow(() -> new CustomException(ErrorMessage.COMMENT_NOT_FOUND));
    }
}

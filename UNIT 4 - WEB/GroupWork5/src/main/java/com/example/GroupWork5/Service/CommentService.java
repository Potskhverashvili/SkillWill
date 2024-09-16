package com.example.GroupWork5.Service;

import com.example.GroupWork5.DTO.commentDto.CommentRequest;
import com.example.GroupWork5.DTO.commentDto.CommentResponse;
import com.example.GroupWork5.DTO.commentDto.ViewComment;
import com.example.GroupWork5.mappers.CommentMapper;
import com.example.GroupWork5.model.CommentEntity;
import com.example.GroupWork5.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    // ---------------------------- Create Comment -----------------------------------
    public CommentResponse createComment(Long postId, CommentRequest commentRequest) {
        CommentEntity commentEntity = CommentMapper.mapRequestToEntity(commentRequest);
        commentEntity.setPostEntity(postService.findPostById(postId));
        CommentEntity save = commentRepository.save(commentEntity);
        return CommentMapper.mapEntityToResponse(save);
    }

    // -------------------------- View All Comment ---------------------------------
    public Page<ViewComment> findAllComment(Integer size, Integer page) {
        Page<ViewComment> comments = commentRepository.findAllComment(PageRequest.of(size, page, Sort.Direction.ASC, "id"));
        if (comments.isEmpty()) {
            throw new EntityNotFoundException("Comments doesn't exist");
        }
        return comments;
    }

    // --------------------------- Update Comment ---------------------------
    public CommentResponse updateComment(Long userId, Long commentId, String updateText){

        CommentEntity commentToUpdate = findCommentById(commentId);
        if (!commentToUpdate.getOwnerId().equals(userId)){
            throw new IllegalArgumentException("You Do Not have permission to update it");
        }
        commentToUpdate.setComment(updateText);
        commentRepository.save(commentToUpdate);
        return CommentMapper.mapEntityToResponse(commentToUpdate);
    }


    public CommentEntity findCommentById(Long id){
        Optional<CommentEntity> byId = commentRepository.findById(id);
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));
    }

    // --------------------------- Delete Comment --------------------------

    public String deleteComment(Long userId, Long commentId){

        CommentEntity commentToDelete = findCommentById(commentId);
        if (!commentToDelete.getOwnerId().equals(userId)){
            throw new IllegalArgumentException("You Do Not have permission to delete it");
        }

        commentRepository.deleteById(commentId);
        return "Deleted comment with ID: " + commentId;
    }

}

/*
package com.example.GroupAssignment.service;


import com.example.GroupAssignment.DTO.postDto.PostRequest;
import com.example.GroupAssignment.DTO.postDto.PostResponse;
import com.example.GroupAssignment.DTO.postDto.ViewPost;
import com.example.GroupAssignment.mapper.postMapper.PostMapper;
import com.example.GroupAssignment.mapper.postMapper.ViewPostMapper;
import com.example.GroupAssignment.model.PostEntity;
import com.example.GroupAssignment.repository.CommentRepository;
import com.example.GroupAssignment.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, UserService userService, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.commentRepository = commentRepository;
    }


    // ----------------------- Create Post -------------------------------
    public PostResponse createPost(Long userId, PostRequest postRequest) {
        PostEntity postEntity = PostMapper.mapRequestToEntity(postRequest);
        postEntity.setUserEntity(userService.findById(userId));
        PostEntity save = postRepository.save(postEntity);
        return PostMapper.mapEntityToResponse(save);
    }

    // ----------------------- View Post -------------------------
    // -- Get Concrete Post --
    public ViewPost viewConcretePost(Long id) {
        return ViewPostMapper.mapEntityToView(findPostById(id));
    }

    // -- Get Post By id --
    public PostEntity findPostById(Long id) {
        Optional<PostEntity> byId = postRepository.findById(id);
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "post/view-concrete/ Post not found"));
    }

    // -- Get All Post --
    public Page<ViewPost> findAllPost(Integer size, Integer page) {
        Page<ViewPost> posts = postRepository.findAllPost((Pageable) PageRequest.of(size, page, Sort.Direction.ASC, "id"));
        if (posts.isEmpty()) {
            throw new EntityNotFoundException("post/view-all/ Post not found");
        }
        return posts;
    }

    // -- Get All Post of User --
    public Page<ViewPost> findAllPostOfUser(Long userId, Integer size, Integer page) {
        Page<ViewPost> posts = postRepository
                .findAllPostOfUser(
                        userId,
                        (Pageable) PageRequest.of(size, page, Sort.Direction.ASC, "id")
                );
        if (posts.isEmpty()) {
            throw new EntityNotFoundException("post/all-of-user/ No posts found for user with ID: " + userId);
        }
        return posts;
    }

    // ---------------------- Update Post ------------------------
    public PostResponse updatePost(Long userId, Long postId, String updateText) {
        // Check if the post exists
        PostEntity postToUpdate = findPostById(postId);

        // Check is owned by the user
        if (!postToUpdate.getId().equals(userId)) {
            throw new IllegalArgumentException("post/update/ You Do Not have permission to update it");
        }

        // Update the post text
        postToUpdate.setText(updateText);

        // Save the updated text to the database
        postRepository.save(postToUpdate);

        return PostMapper.mapEntityToResponse(postToUpdate);
    }

    // ---------------------- Delete Post ------------------------
    public String deletePost(Long userId, Long postId) {
        // Check if the post exists
        PostEntity postToDelete = findPostById(postId);

        // Check is owned by the user
        if (!postToDelete.getId().equals(userId)) {
            throw new IllegalArgumentException("post/delete/ You Do Not have permission to delete it");
        }

        commentRepository.deleteCommentByPostId(postId);
        postRepository.deleteById(postId);
        return "Deleted post with ID: " + postId;
    }
}
*/

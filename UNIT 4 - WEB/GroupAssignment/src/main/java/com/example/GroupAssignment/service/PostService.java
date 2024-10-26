package com.example.GroupAssignment.service;

import com.example.GroupAssignment.DTO.postDto.PostRequest;
import com.example.GroupAssignment.DTO.postDto.PostResponse;
import com.example.GroupAssignment.DTO.postDto.ViewPost;
import com.example.GroupAssignment.exception.CustomException;
import com.example.GroupAssignment.mapper.postMapper.PostMapper;
import com.example.GroupAssignment.mapper.postMapper.ViewPostMapper;
import com.example.GroupAssignment.exception.ErrorMessage;
import com.example.GroupAssignment.model.PostEntity;
import com.example.GroupAssignment.repository.CommentRepository;
import com.example.GroupAssignment.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

        postEntity.setUserEntity(userService.checkUserIfExist(userId));
        PostEntity savePost = postRepository.save(postEntity);

        return PostMapper.mapEntityToResponse(savePost);
    }

    //TODO
    // ------------------------ View Post --------------------------------
    public ViewPost viewConcretePost(Long postId, Long userId) {
        PostEntity post = checkPostIfExist(postId);

        // Validation
        if (!post.getUserEntity().getId().equals(userId))
            throw new CustomException(ErrorMessage.NOT_ALLOWED);

        return ViewPostMapper.mapPostEntityToView(post);
    }

    // -- Get All Post --
    public Page<ViewPost> findAllPost(Integer size, Integer page) {
        Page<ViewPost> posts = postRepository.
                findAllPost(
                        PageRequest.of(
                                size, page,
                                Sort.Direction.ASC,
                                "id")
                );

        if (posts.isEmpty()) {
            throw new CustomException(ErrorMessage.POST_NOT_FOUND);
        }
        return posts;
    }

    // -- Get All Post of User --
    public Page<ViewPost> findAllPostOfUser(Long userId, Integer size, Integer page) {
        Page<ViewPost> posts = postRepository
                .findAllPostOfUser(
                        userId,
                        PageRequest.of(
                                size, page,
                                Sort.Direction.ASC,
                                "id")
                );
        if (posts.isEmpty()) {
            throw new CustomException(ErrorMessage.POST_NOT_FOUND);
        }
        return posts;
    }

    // ---------------------- Update Post ------------------------
    public PostResponse updatePost(Long userId, Long postId, String updateText) {

        PostEntity postToUpdate = checkPostIfExist(postId); // Check if the post exists

        // Check is owned by the user
        if (!postToUpdate.getUserEntity().getId().equals(userId)) {
            throw new CustomException(ErrorMessage.NOT_ALLOWED);
        }

        postToUpdate.setText(updateText); // Update the post text
        postRepository.save(postToUpdate); // Save the updated text to the database

        return PostMapper.mapEntityToResponse(postToUpdate);
    }

    // ---------------------- Delete Post ------------------------
    public String deletePost(Long userId, Long postId) {
        // Check if the post exists
        PostEntity postToDelete = checkPostIfExist(postId);

        // Check is owned by the user
        if (!postToDelete.getUserEntity().getId().equals(userId)) {
            throw new CustomException(ErrorMessage.NOT_ALLOWED);
        }

        commentRepository.deleteCommentByPostId(postId);
        postRepository.deleteById(postId);
        return "Deleted Successfully Post with ID: " + postId;
    }

    // --------------------- Helper Method --------------------------
    public PostEntity checkPostIfExist(Long id) {
        Optional<PostEntity> byId = postRepository.findById(id);
        return byId.orElseThrow(() -> new CustomException(ErrorMessage.POST_NOT_FOUND));
    }
}

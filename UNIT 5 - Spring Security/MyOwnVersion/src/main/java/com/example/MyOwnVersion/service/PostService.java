package com.example.MyOwnVersion.service;

import com.example.MyOwnVersion.dto.request.PostRequest;
import com.example.MyOwnVersion.dto.responce.PostResponse;
import com.example.MyOwnVersion.dto.view.ViewPost;
import com.example.MyOwnVersion.exception.CustomException;
import com.example.MyOwnVersion.exception.ErrorMessage;
import com.example.MyOwnVersion.mapper.postMapper.PostMapper;
import com.example.MyOwnVersion.mapper.postMapper.ViewPostMapper;
import com.example.MyOwnVersion.model.PostEntity;
import com.example.MyOwnVersion.model.UserEntity;
import com.example.MyOwnVersion.model.enums.Roles;
import com.example.MyOwnVersion.repository.CommentRepository;
import com.example.MyOwnVersion.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public PostResponse createPost(PostRequest postRequest) {

        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        // Find User
        UserEntity createdBy = userService.findUser(principal);
        PostEntity postEntity = PostMapper.mapRequestToEntity(postRequest);
        postEntity.setUserEntity(createdBy); // Set created user
        PostEntity savePost = postRepository.save(postEntity);

        return PostMapper.mapEntityToResponse(savePost);
    }

    public ViewPost viewConcretePost(Long postId) {
        PostEntity post = checkPostIfExist(postId);
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
    public Page<ViewPost> findAllPostOfUser(Integer size, Integer page) {
        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        Page<ViewPost> posts = postRepository
                .findAllPostOfUser(
                        principal,
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
    public PostResponse updatePost(Long postId, PostRequest postRequest) {

        // Check if the post exists
        PostEntity postToUpdate = checkPostIfExist(postId);

        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        Roles isAdmin = userService.findUser(principal).getRole();

        // Check is owned by the user or isAdmin
        if (postToUpdate.getUserEntity().getId().equals(principal) || isAdmin.equals(Roles.ROLE_ADMIN)) {
            postToUpdate.setText(postRequest.getText()); // Update the post text
            postRepository.save(postToUpdate); // Save the updated text to the database
        } else {
            throw new CustomException(ErrorMessage.NOT_ALLOWED);
        }

        return PostMapper.mapEntityToResponse(postToUpdate);
    }

    // ---------------------- Delete Post ------------------------
    public String deletePost(Long postId) {
        // Check if the post exists
        PostEntity postToUpdate = checkPostIfExist(postId);

        // Get logged-im user id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        long principal = (long) authentication.getPrincipal();

        Roles isAdmin = userService.findUser(principal).getRole();

        // Check is owned by the user or isAdmin
        if (postToUpdate.getUserEntity().getId().equals(principal) || isAdmin.equals(Roles.ROLE_ADMIN)) {
            commentRepository.deleteCommentByPostId(postId);
            postRepository.deleteById(postId);
        } else {
            throw new CustomException(ErrorMessage.NOT_ALLOWED);
        }

        return "Deleted Successfully Post with ID: " + postId;
    }

    // --------------------- Helper Method --------------------------
    public PostEntity checkPostIfExist(Long id) {
        Optional<PostEntity> byId = postRepository.findById(id);
        return byId.orElseThrow(() -> new CustomException(ErrorMessage.POST_NOT_FOUND));
    }
}

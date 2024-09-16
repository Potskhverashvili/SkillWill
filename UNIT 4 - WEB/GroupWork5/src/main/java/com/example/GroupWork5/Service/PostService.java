package com.example.GroupWork5.Service;

import com.example.GroupWork5.DTO.postDto.PostRequest;
import com.example.GroupWork5.DTO.postDto.PostResponse;
import com.example.GroupWork5.DTO.postDto.ViewPost;
import com.example.GroupWork5.mappers.PostMapper;
import com.example.GroupWork5.mappers.ViewPostMapper;
import com.example.GroupWork5.model.PostEntity;
import com.example.GroupWork5.repository.CommentRepository;
import com.example.GroupWork5.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return byId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }

    // -- Get All Post --
    public Page<ViewPost> findAllPost(Integer size, Integer page) {
        Page<ViewPost> posts = postRepository.findAllPost(PageRequest.of(size, page, Sort.Direction.DESC, "id"));
        if (posts.isEmpty()) {
            throw new EntityNotFoundException("Post doesn't exist");
        }
        return posts;
    }

    // -- Get All Post of User --
    public Page<ViewPost> findAllPostOfUser(Long userId, Integer size, Integer page) {
        Page<ViewPost> posts = postRepository
                .findAllPostOfUser(
                        userId,
                        PageRequest.of(size, page, Sort.Direction.ASC, "id")
                );
        if (posts.isEmpty()) {
            throw new EntityNotFoundException("No posts found for user with ID: " + userId);
        }
        return posts;
    }

    // ---------------------- Update Post ------------------------
    public PostResponse updatePost(Long userId, Long postId, String updateText) {
        // Check if the post exists
        PostEntity postToUpdate = findPostById(postId);

        // Check is owned by the user
        if (!postToUpdate.getUserId().equals(userId)) {
            throw new IllegalArgumentException("You Do Not have permission to update it");
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
        if (!postToDelete.getUserId().equals(userId)) {
            throw new IllegalArgumentException("You Do Not have permission to delete it");
        }

        commentRepository.deleteCommentByPostId(postId);
        postRepository.deleteById(postId);
        return "Deleted post with ID: " + postId;
    }
}

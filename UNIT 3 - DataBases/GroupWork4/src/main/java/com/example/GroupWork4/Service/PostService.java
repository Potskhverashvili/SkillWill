package com.example.GroupWork4.Service;

import com.example.GroupWork4.repository.CommentRepository;
import com.example.GroupWork4.repository.PostRepository;
import com.example.GroupWork4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository usersRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository, UserRepository usersRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;
        this.commentRepository = commentRepository;
    }


    // ------ Create Post ---------

    // ------ Update Post ---------

    // ------ Delete Post -------

    // ------- Find All Post -------

    // ------- Find by Post Id ------

    // ------- Find by userName -------
}

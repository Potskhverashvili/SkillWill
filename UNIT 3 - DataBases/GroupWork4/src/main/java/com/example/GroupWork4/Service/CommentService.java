package com.example.GroupWork4.Service;

import com.example.GroupWork4.repository.CommentRepository;
import com.example.GroupWork4.repository.PostRepository;
import com.example.GroupWork4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository usersRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository usersRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;
    }

    // -------- Create Comment ---------

    // ------- Update Comment -----------

    // ------- Delete Comment ------------

    // -------- FindAll Comment ---------
}





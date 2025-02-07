package com.kamuridesu.social_scheduler.domain.service;

import org.springframework.stereotype.Service;

import com.kamuridesu.social_scheduler.domain.model.Post;
import com.kamuridesu.social_scheduler.domain.repository.PostRepository;
import com.kamuridesu.social_scheduler.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostSchedulerService {
    
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    void schedule(Post post) {
        postRepository.save(post);
    }

}

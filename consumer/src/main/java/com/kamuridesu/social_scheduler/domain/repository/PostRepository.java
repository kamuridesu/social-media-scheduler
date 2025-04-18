package com.kamuridesu.social_scheduler.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamuridesu.social_scheduler.domain.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}

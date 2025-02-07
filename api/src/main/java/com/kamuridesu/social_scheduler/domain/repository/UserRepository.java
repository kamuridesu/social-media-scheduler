package com.kamuridesu.social_scheduler.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamuridesu.social_scheduler.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}

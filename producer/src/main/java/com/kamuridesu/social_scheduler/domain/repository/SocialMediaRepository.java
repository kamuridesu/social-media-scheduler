package com.kamuridesu.social_scheduler.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamuridesu.social_scheduler.domain.model.SocialMedia;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {
    
}

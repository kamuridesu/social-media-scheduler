package com.kamuridesu.social_scheduler.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    Long id;
    
    @Column(unique = true)
    String username;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<SocialMedia> socialMedia;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Post> posts;
    
}

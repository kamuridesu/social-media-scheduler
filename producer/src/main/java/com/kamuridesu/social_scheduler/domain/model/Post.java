package com.kamuridesu.social_scheduler.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue
    Long id;

    String body;
    Integer delay;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "published_at")
    LocalDateTime publishedAt;

    Boolean published = false;

    @ManyToOne()
    @JoinColumn(name = "social_id", nullable = false)
    SocialMedia social;

}

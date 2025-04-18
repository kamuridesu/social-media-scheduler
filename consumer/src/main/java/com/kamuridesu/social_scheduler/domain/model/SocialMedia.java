package com.kamuridesu.social_scheduler.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SocialMedia {
    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String name;

    String token;
    String expiresAt;
    String refreshToken;
    String refreshExpiresAt;
}

package com.kamuridesu.social_scheduler.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "social")
@Data
public class SocialMedia {
    @Id
    @GeneratedValue
    Long id;

    String platform;

    @Nullable
    String username;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToMany(mappedBy = "social", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> posts;

    String token;
    @Column(name = "expires_at")
    String expiresAt;
    @Column(name = "refresh_token")
    String refreshToken;
    @Column(name = "refresh_expires_at")
    String refreshExpiresAt;
}

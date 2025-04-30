package com.kamuridesu.social_scheduler.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String username;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<SocialMedia> socialMedias;

}

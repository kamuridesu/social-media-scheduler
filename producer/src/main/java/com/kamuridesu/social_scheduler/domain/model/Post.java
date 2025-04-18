package com.kamuridesu.social_scheduler.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue
    Long id;

    String body;
    Integer delay;
    Integer creation_timestamp;

}

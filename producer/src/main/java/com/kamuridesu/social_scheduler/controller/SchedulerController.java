package com.kamuridesu.social_scheduler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamuridesu.social_scheduler.domain.model.Post;
import com.kamuridesu.social_scheduler.domain.service.PostSchedulerService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final PostSchedulerService schedulerService;

    @PostMapping("/{socialId}")
    public ResponseEntity<String> schedule(@PathVariable Long socialId, @RequestBody Post post) {
        schedulerService.schedule(socialId, post);
        return ResponseEntity.status(200).body("success");
    }
    
}

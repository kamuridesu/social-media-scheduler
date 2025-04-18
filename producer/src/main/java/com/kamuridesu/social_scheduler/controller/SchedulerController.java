package com.kamuridesu.social_scheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kamuridesu.social_scheduler.domain.service.PostSchedulerService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final PostSchedulerService schedulerService;

    @GetMapping("/test")
    public String test() {
        schedulerService.publish();
        return "ok";
    }
    
}

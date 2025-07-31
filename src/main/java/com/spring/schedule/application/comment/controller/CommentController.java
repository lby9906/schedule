package com.spring.schedule.application.comment.controller;

import com.spring.schedule.application.comment.dto.request.CommentRequest;
import com.spring.schedule.application.comment.dto.response.CommentResponse;
import com.spring.schedule.application.comment.service.CommentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentWriteService commentWriteService;

    @PostMapping("/{scheduleId}")
    public CommentResponse create(@RequestBody CommentRequest request, @PathVariable Long scheduleId) {
        return commentWriteService.create(request, scheduleId);
    }
}

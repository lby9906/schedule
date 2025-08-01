package com.spring.schedule.application.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleCommentResponse {
    private Long commentId;
    private Long scheduleId;
    private String name;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.spring.schedule.application.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleUpdateResponse {
    private Long id;
    private String title;
    private String contents;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

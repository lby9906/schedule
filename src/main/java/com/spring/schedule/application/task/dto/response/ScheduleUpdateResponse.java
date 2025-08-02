package com.spring.schedule.application.task.dto.response;

import com.spring.schedule.domain.task.entity.Schedule;
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

    public static ScheduleUpdateResponse from(Schedule schedule, LocalDateTime updatedAt) {
        return new ScheduleUpdateResponse(
                schedule.getId(), schedule.getTitle(),
                schedule.getContents(), schedule.getName(),
                schedule.getCreatedAt(), updatedAt);
    }
}

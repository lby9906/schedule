package com.spring.schedule.application.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleUpdateRequest {
    private String title;
    private String name;
    private String password;
}

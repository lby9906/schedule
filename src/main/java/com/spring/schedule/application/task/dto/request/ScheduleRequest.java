package com.spring.schedule.application.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequest {
    private String title;
    private String contents;
    private String name;
    private String password;
}

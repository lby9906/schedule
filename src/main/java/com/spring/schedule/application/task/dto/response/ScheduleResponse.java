package com.spring.schedule.application.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private String title;
    private String contents;
    private String name;
}

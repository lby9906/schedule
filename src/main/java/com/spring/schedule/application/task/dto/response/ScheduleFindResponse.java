package com.spring.schedule.application.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleFindResponse {
    private List<ScheduleResponse> scheduleResponses;
    private ScheduleResponse scheduleResponse;
}

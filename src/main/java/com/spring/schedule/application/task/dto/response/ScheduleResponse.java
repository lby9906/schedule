package com.spring.schedule.application.task.dto.response;

import com.spring.schedule.domain.task.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private String title;
    private String contents;
    private String name;

    public static ScheduleResponse from(Schedule schedule) {
        return new ScheduleResponse(schedule.getId(), schedule.getTitle(),
                schedule.getContents(), schedule.getName());
    }
}

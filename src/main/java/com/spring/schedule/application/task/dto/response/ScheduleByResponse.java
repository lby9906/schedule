package com.spring.schedule.application.task.dto.response;

import com.spring.schedule.domain.task.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleByResponse {
    private Long id;
    private String title;
    private String contents;
    private String name;
    private List<ScheduleCommentResponse> scheduleCommentResponses;

    public static ScheduleByResponse from(Schedule schedule, List<ScheduleCommentResponse> commentResponses) {
        return new ScheduleByResponse(
                schedule.getId(), schedule.getTitle(),
                schedule.getContents(), schedule.getName(), commentResponses);
    }
}

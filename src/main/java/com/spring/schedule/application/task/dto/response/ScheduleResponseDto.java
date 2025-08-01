package com.spring.schedule.application.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String name;
    private List<ScheduleCommentResponse> scheduleCommentResponses;
}

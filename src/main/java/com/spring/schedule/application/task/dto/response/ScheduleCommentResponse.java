package com.spring.schedule.application.task.dto.response;

import com.spring.schedule.domain.comment.entity.Comment;
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

    public static ScheduleCommentResponse from(Comment comment) {
        return new ScheduleCommentResponse(
                comment.getId(), comment.getScheduleId(),
                comment.getName(), comment.getContents(),
                comment.getCreatedAt(), comment.getUpdatedAt());
    }
}

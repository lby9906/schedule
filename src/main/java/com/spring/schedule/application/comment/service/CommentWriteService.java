package com.spring.schedule.application.comment.service;

import com.spring.schedule.application.comment.dto.request.CommentRequest;
import com.spring.schedule.application.comment.dto.response.CommentResponse;
import com.spring.schedule.domain.comment.entity.Comment;
import com.spring.schedule.domain.comment.repository.CommentRepository;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import com.spring.schedule.exception.ErrorCode;
import com.spring.schedule.exception.ScheduleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentWriteService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponse create(CommentRequest request, Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(() ->
                new ScheduleException(ErrorCode.NOT_FOUND_SCHEDULE));

        if (commentRepository.countByScheduleId(scheduleId) >= 10) {
            throw new ScheduleException(ErrorCode.ONLY_TEN_REGISTER_COMMENTS);
        }

        Comment comment = Comment.of(request.getContents(), request.getName(), request.getPassword(), schedule.getId());
        commentRepository.save(comment);

        return new CommentResponse(comment.getId(), comment.getScheduleId(),
                comment.getName(), comment.getContents(), comment.getCreatedAt(),
                comment.getUpdatedAt());
    }
}

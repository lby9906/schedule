package com.spring.schedule.application.comment.service;

import com.spring.schedule.application.comment.dto.request.CommentRequest;
import com.spring.schedule.application.comment.dto.response.CommentResponse;
import com.spring.schedule.domain.comment.entity.Comment;
import com.spring.schedule.domain.comment.repository.CommentRepository;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentWriteService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponse create(CommentRequest request, Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "등록된 일정이 없습니다."));

        if (commentRepository.countByScheduleId(scheduleId) > 10) {
            throw new IllegalArgumentException("10개의 댓글만 작성할 수 있습니다.");
        }

        Comment comment = Comment.of(request.getContents(), request.getName(), request.getPassword(), schedule.getId());
        commentRepository.save(comment);

        return new CommentResponse(comment.getId(), comment.getScheduleId(),
                comment.getName(), comment.getContents(), comment.getCreatedAt(),
                comment.getUpdatedAt());
    }
}

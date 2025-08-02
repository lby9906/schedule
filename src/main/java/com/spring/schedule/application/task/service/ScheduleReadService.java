package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.response.ScheduleCommentResponse;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.dto.response.ScheduleByResponse;
import com.spring.schedule.domain.comment.entity.Comment;
import com.spring.schedule.domain.comment.repository.CommentRepository;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import com.spring.schedule.exception.ErrorCode;
import com.spring.schedule.exception.ScheduleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleReadService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    //전체 일정 조회
    public List<ScheduleResponse> findAll(String name) {
        List<Schedule> scheduleList = scheduleRepository.findAllScheduleOrderByUpdatedAtDesc(name);
        return scheduleList.stream()
                .map(schedule -> ScheduleResponse.from(schedule))
                .collect(Collectors.toList());
    }

    //선택 일정 조회
    public ScheduleByResponse findById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleException(ErrorCode.NOT_FOUND_SCHEDULE));

        List<Comment> commentList = commentRepository.findCommentByScheduleId(scheduleId);
        List<ScheduleCommentResponse> commentResponses = commentList
                .stream()
                .map(comment -> ScheduleCommentResponse.from(comment))
                .collect(Collectors.toList());

        return ScheduleByResponse.from(schedule, commentResponses);

    }
}

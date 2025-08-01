package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.response.ScheduleCommentResponse;
import com.spring.schedule.application.task.dto.response.ScheduleFindResponse;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.dto.response.ScheduleResponseDto;
import com.spring.schedule.domain.comment.entity.Comment;
import com.spring.schedule.domain.comment.repository.CommentRepository;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
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

    //일정 조회
    public ScheduleFindResponse find(Long scheduleId, String name) {
        if (scheduleId == null && name == null) {
            List<Schedule> findSchedules = scheduleRepository.findAllByOrderByUpdatedAtDesc();
            List<ScheduleResponse> scheduleResponseList = findSchedules
                    .stream()
                    .map(task -> new ScheduleResponse(
                            task.getId(), task.getTitle(),
                            task.getContents(), task.getName()))
                    .collect(Collectors.toList());

            return new ScheduleFindResponse(scheduleResponseList, null);
        } else if (scheduleId == null && name != null) {
            List<Schedule> scheduleByName = scheduleRepository.findAllScheduleByName(name);
            List<ScheduleResponse> scheduleNameList = scheduleByName
                    .stream()
                    .map(task -> new ScheduleResponse(
                            task.getId(), task.getTitle(),
                            task.getContents(), task.getName()))
                    .collect(Collectors.toList());

            return new ScheduleFindResponse(scheduleNameList, null);
        }
        else {
            Schedule schedule = scheduleRepository.findScheduleById(scheduleId).get();
            List<Comment> commentByScheduleId = commentRepository.findCommentByScheduleId(scheduleId);

            List<ScheduleCommentResponse> commentResponses = commentByScheduleId
                    .stream()
                    .map(comment -> new ScheduleCommentResponse(
                            comment.getId(), comment.getScheduleId(),
                            comment.getName(), comment.getContents(),
                            comment.getCreatedAt(), comment.getUpdatedAt()
                    )
            ).collect(Collectors.toList());

            return new ScheduleFindResponse(null,
                    new ScheduleResponseDto(schedule.getId(), schedule.getTitle(),
                            schedule.getContents(), schedule.getName(), commentResponses));
        }
    }
}

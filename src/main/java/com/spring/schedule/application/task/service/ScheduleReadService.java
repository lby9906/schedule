package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.response.ScheduleResponse;
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

    //전체 일정 조회
    public List<ScheduleResponse> findAll(String name) {
        List<Schedule> scheduleList = scheduleRepository.findAllScheduleOrderByUpdatedAtDesc(name);
        return scheduleList.stream().map(schedule -> new ScheduleResponse(
                schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getName()
        )).collect(Collectors.toList());
    }
}

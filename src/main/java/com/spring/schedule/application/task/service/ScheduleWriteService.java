package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.request.ScheduleRequest;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleWriteService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponse create(ScheduleRequest request) {
        Schedule schedule = Schedule.of(request.getTitle(), request.getContents(), request.getName(), request.getPassword());
        scheduleRepository.save(schedule);

        return new ScheduleResponse(schedule.getId(), schedule.getContents(), schedule.getContents(), schedule.getName());
    }
}

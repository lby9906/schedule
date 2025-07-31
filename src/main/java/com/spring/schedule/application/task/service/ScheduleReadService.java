package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.response.ScheduleFindResponse;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleReadService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleFindResponse findAll(Long scheduleId) {
        if (scheduleId == null) {
            List<Schedule> findSchedules = scheduleRepository.findAllByOrderByUpdatedAtDesc();
            List<ScheduleResponse> scheduleResponseList = findSchedules
                    .stream()
                    .map(task -> new ScheduleResponse(
                            task.getId(), task.getTitle(),
                            task.getContents(), task.getName()))
                    .collect(Collectors.toList());

            return new ScheduleFindResponse(scheduleResponseList, null);
        } else {
            Schedule schedule = scheduleRepository.findScheduleById(scheduleId).get();
            return new ScheduleFindResponse(null,
                    new ScheduleResponse(schedule.getId(), schedule.getTitle(),
                            schedule.getContents(), schedule.getName()));
        }
    }
}

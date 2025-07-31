package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.request.ScheduleRequest;
import com.spring.schedule.application.task.dto.request.ScheduleUpdateRequest;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.dto.response.ScheduleUpdateResponse;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    public ScheduleUpdateResponse update(ScheduleUpdateRequest request, Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "등록된 일정이 없습니다."));

        if (request.getPassword().equals(schedule.getPassword())) {
            schedule.update(request.getTitle(), request.getName());
            return new ScheduleUpdateResponse(
                    schedule.getId(), schedule.getTitle(),
                    schedule.getContents(), schedule.getName(),
                    schedule.getCreatedAt(), schedule.getUpdatedAt());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }
    }
}

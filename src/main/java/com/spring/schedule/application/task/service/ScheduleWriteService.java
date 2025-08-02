package com.spring.schedule.application.task.service;

import com.spring.schedule.application.task.dto.request.ScheduleRequest;
import com.spring.schedule.application.task.dto.request.ScheduleUpdateRequest;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.dto.response.ScheduleUpdateResponse;
import com.spring.schedule.domain.task.entity.Schedule;
import com.spring.schedule.domain.task.repository.ScheduleRepository;
import com.spring.schedule.exception.ErrorCode;
import com.spring.schedule.exception.ScheduleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleWriteService {

    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponse create(ScheduleRequest request) {
        Schedule schedule = Schedule.of(request.getTitle(), request.getContents(), request.getName(), request.getPassword());
        scheduleRepository.save(schedule);

        return new ScheduleResponse(schedule.getId(), schedule.getContents(), schedule.getContents(), schedule.getName());
    }

    //일정 수정
    public ScheduleUpdateResponse update(ScheduleUpdateRequest request, Long scheduleId, LocalDateTime updateAt) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(
                () -> new ScheduleException(ErrorCode.NOT_FOUND_SCHEDULE));

        if (request.getPassword().equals(schedule.getPassword())) {
            schedule.update(request.getTitle(), request.getName());
            return new ScheduleUpdateResponse(
                    schedule.getId(), schedule.getTitle(),
                    schedule.getContents(), schedule.getName(),
                    schedule.getCreatedAt(), updateAt);
        } else {
            throw new ScheduleException(ErrorCode.NOT_MATCH_EMAIL_PASSWORD);
        }
    }

    //일정 삭제
    public String remove(Long scheduleId, String password) {
        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(() ->
                new ScheduleException(ErrorCode.NOT_FOUND_SCHEDULE));

        if (password.equals(schedule.getPassword())) {
            scheduleRepository.delete(schedule);
        }else {
            throw new ScheduleException(ErrorCode.NOT_MATCH_EMAIL_PASSWORD);
        }

        return "삭제 완료";
    }
}

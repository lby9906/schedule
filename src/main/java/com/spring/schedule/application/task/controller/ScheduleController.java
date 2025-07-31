package com.spring.schedule.application.task.controller;

import com.spring.schedule.application.task.dto.request.ScheduleRequest;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.service.ScheduleWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleWriteService scheduleWriteService;

    @PostMapping
    public ScheduleResponse create(@RequestBody ScheduleRequest scheduleRequest) {
        return scheduleWriteService.create(scheduleRequest);
    }
}

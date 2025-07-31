package com.spring.schedule.application.task.controller;

import com.spring.schedule.application.task.dto.request.ScheduleRequest;
import com.spring.schedule.application.task.dto.request.ScheduleUpdateRequest;
import com.spring.schedule.application.task.dto.response.ScheduleFindResponse;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.dto.response.ScheduleUpdateResponse;
import com.spring.schedule.application.task.service.ScheduleReadService;
import com.spring.schedule.application.task.service.ScheduleWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleWriteService scheduleWriteService;
    private final ScheduleReadService scheduleReadService;

    @PostMapping
    public ScheduleResponse create(@RequestBody ScheduleRequest scheduleRequest) {
        return scheduleWriteService.create(scheduleRequest);
    }

    @GetMapping({"","/{scheduleId}"})
    public ScheduleFindResponse findAll(@PathVariable(required = false) Long scheduleId) {
        return scheduleReadService.findAll(scheduleId);
    }

    @PatchMapping("/{scheduleId}")
    public ScheduleUpdateResponse update(@RequestBody ScheduleUpdateRequest request, @PathVariable Long scheduleId) {
        return scheduleWriteService.update(request, scheduleId);
    }
}

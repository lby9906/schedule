package com.spring.schedule.application.task.controller;

import com.spring.schedule.application.task.dto.request.ScheduleRequest;
import com.spring.schedule.application.task.dto.request.ScheduleUpdateRequest;
import com.spring.schedule.application.task.dto.response.ScheduleResponse;
import com.spring.schedule.application.task.dto.response.ScheduleByResponse;
import com.spring.schedule.application.task.dto.response.ScheduleUpdateResponse;
import com.spring.schedule.application.task.service.ScheduleReadService;
import com.spring.schedule.application.task.service.ScheduleWriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleWriteService scheduleWriteService;
    private final ScheduleReadService scheduleReadService;

    @PostMapping
    public ScheduleResponse create(@RequestBody @Valid ScheduleRequest scheduleRequest) {
        return scheduleWriteService.create(scheduleRequest);
    }

    @GetMapping
    public List<ScheduleResponse> findAll(@RequestParam(required = false) String name) {
        return scheduleReadService.findAll(name);
    }

    @GetMapping("/{scheduleId}")
    public ScheduleByResponse findById(@PathVariable Long scheduleId) {
        return scheduleReadService.findById(scheduleId);
    }

    @PatchMapping("/{scheduleId}")
    public ScheduleUpdateResponse update(@RequestBody @Valid ScheduleUpdateRequest request, @PathVariable Long scheduleId) {
        return scheduleWriteService.update(request, scheduleId);
    }

    @DeleteMapping("/{scheduleId}")
    public String remove(@PathVariable Long scheduleId, @RequestParam String password) {
        return scheduleWriteService.remove(scheduleId, password);
    }
}

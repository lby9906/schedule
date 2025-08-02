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

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleWriteService scheduleWriteService;
    private final ScheduleReadService scheduleReadService;

    //일정 생성
    @PostMapping
    public ScheduleResponse create(@RequestBody @Valid ScheduleRequest scheduleRequest) {
        return scheduleWriteService.create(scheduleRequest);
    }

    //일정 전체 조회
    @GetMapping
    public List<ScheduleResponse> findAll(@RequestParam(required = false) String name) {
        return scheduleReadService.findAll(name);
    }

    //일정 상세 조회
    @GetMapping("/{scheduleId}")
    public ScheduleByResponse findById(@PathVariable Long scheduleId) {
        return scheduleReadService.findById(scheduleId);
    }

    //일정 수정
    @PatchMapping("/{scheduleId}")
    public ScheduleUpdateResponse update(@RequestBody @Valid ScheduleUpdateRequest request, @PathVariable Long scheduleId) {
        LocalDateTime now = LocalDateTime.now();
        return scheduleWriteService.update(request, scheduleId, now);
    }

    //일정 삭제
    @DeleteMapping("/{scheduleId}")
    public String remove(@PathVariable Long scheduleId, @RequestParam String password) {
        return scheduleWriteService.remove(scheduleId, password);
    }
}

package com.spring.schedule.domain.task.repository;

import com.spring.schedule.domain.task.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

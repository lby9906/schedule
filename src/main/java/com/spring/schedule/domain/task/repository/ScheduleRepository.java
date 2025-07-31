package com.spring.schedule.domain.task.repository;

import com.spring.schedule.domain.task.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByOrderByUpdatedAtDesc();
    Optional<Schedule> findScheduleById(Long id);
    List<Schedule> findAllScheduleByName(String name);
}

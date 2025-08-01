package com.spring.schedule.domain.comment.repository;

import com.spring.schedule.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    int countByScheduleId(Long scheduleId);
    List<Comment> findCommentByScheduleId(Long scheduleId);
}

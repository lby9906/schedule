package com.spring.schedule.domain.comment.entity;

import com.spring.schedule.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {
    private String contents;
    private String name;
    private String password;
    private Long scheduleId;

    public static Comment of(String contents, String name, String password, Long scheduleId) {
        return new Comment(contents, name, password, scheduleId);
    }
}

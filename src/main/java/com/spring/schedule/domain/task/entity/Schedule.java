package com.spring.schedule.domain.task.entity;

import com.spring.schedule.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends BaseEntity {
    private String title;
    private String contents;
    private String name;
    private String password;

    public static Schedule of(String title, String contents, String name, String password) {
        return new Schedule(title, contents, name, password);
    }

    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}

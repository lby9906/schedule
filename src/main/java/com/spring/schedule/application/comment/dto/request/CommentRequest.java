package com.spring.schedule.application.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequest {
    private String contents;
    private String name;
    private String password;
}

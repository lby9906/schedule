package com.spring.schedule.application.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentRequest {

    @NotBlank(message = "내용을 필수로 입력해주세요.")
    @Size(min = 1, max = 100, message = "내용을 1 ~ 100자 사이로 입력해주세요.")
    private String contents;

    @NotBlank(message = "이름을 필수로 입력해주세요.")
    @Size(min = 1, max = 20, message = "이름을 1 ~ 20자 사이로 입력해주세요.")
    private String name;

    @NotBlank(message = "비밀번호를 필수로 입력해주세요.")
    @Size(min = 1, max = 30, message = "비밀번호를 1 ~ 30자 사이로 입력해주세요.")
    private String password;
}

package com.spring.schedule.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleException extends RuntimeException{

    private ErrorCode errorCode;
}

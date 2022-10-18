package com.soloproject.soloProject.tasks;

import lombok.Getter;

public enum ExceptionCode {
    TASK_NOT_EXIST(404, "TASK_NOT_EXIST");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status =  code;
        this.message = message;
    }
}

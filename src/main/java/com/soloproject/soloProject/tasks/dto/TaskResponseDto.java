package com.soloproject.soloProject.tasks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
    private int taskId;

    private String title;

    private int order;

    private boolean complete;
}

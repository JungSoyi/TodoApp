package com.soloproject.soloProject.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private int taskId;
    private String title;
    private int order;
    private boolean complete;
}

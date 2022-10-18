package com.soloproject.soloProject.tasks;

import com.soloproject.soloProject.tasks.dto.TaskPatchDto;
import com.soloproject.soloProject.tasks.dto.TaskPostDto;
import com.soloproject.soloProject.tasks.dto.TaskResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task taskPostDtoToTask(TaskPostDto taskPostDto);
    Task taskPatchDtoToTask(TaskPatchDto taskPatchDto);
    TaskResponseDto taskToTaskResponseDto(Task task);

//    public Task taskPostDtoToTask(TaskPostDto taskPostDto){
//        return new Task(0,
//                taskPostDto.getTitle(),
//                taskPostDto.getOrder(),
//                taskPostDto.getComplete());
//    }
//
//    public Task taskPatchDtoToTask(TaskPatchDto taskPatchDto){
//        return new Task(taskPatchDto.getTaskId(),
//                taskPatchDto.getTitle(),
//                taskPatchDto.getOrder(),
//                taskPatchDto.getComplete());
//    }
//
//    public TaskResponseDto taskToTaskResponseDto(Task task){
//        return new TaskResponseDto(task.getTaskId(),
//                task.getTitle(),
//                task.getOrder(),
//                task.isComplete()); // boolean type 은 get -> is
//    }
}

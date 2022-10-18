package com.soloproject.soloProject.tasks;

import com.soloproject.soloProject.tasks.dto.TaskPatchDto;
import com.soloproject.soloProject.tasks.dto.TaskPostDto;
import com.soloproject.soloProject.tasks.dto.TaskResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.soloproject.soloProject.tasks.TaskMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/")
@RestController
public class TasksController {

    private final TaskService taskService;
    private final TaskMapper mapper;

    public TasksController(TaskService taskService, TaskMapper mapper){
        this.taskService = taskService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postTask(@RequestBody TaskPostDto taskPostDto){

        Task task = mapper.taskPostDtoToTask(taskPostDto);

        Task response = taskService.createTask(task);

        return new ResponseEntity<>(mapper.taskToTaskResponseDto(response), HttpStatus.CREATED);

    }

    @GetMapping("/{task-id}")
    public ResponseEntity getTask(@PathVariable("task-id") int taskId){
        Task response = taskService.findTask(taskId);
        return new ResponseEntity<>(mapper.taskToTaskResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTasks(){
        List<Task> tasks = taskService.findTasks();

        List<TaskResponseDto> response =
                tasks.stream()
                        .map(task -> mapper.taskToTaskResponseDto(task))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{task-id}")
    public ResponseEntity patchTask(@PathVariable("task-id") int taskId,
                                    @RequestBody TaskPatchDto taskPatchDto){
        taskPatchDto.setTaskId(taskId);

        Task response = taskService.updateTask(mapper.taskPatchDtoToTask(taskPatchDto));

        return new ResponseEntity<>(mapper.taskToTaskResponseDto(response), HttpStatus.OK);
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity deleteTask(@PathVariable("task-id") int taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

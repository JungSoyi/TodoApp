package com.soloproject.soloProject.tasks;

import com.soloproject.soloProject.tasks.dto.TaskPatchDto;
import com.soloproject.soloProject.tasks.dto.TaskPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService){
        this.taskService = taskService;
    }
    @PostMapping
    public ResponseEntity postTask(@RequestBody TaskPostDto taskPostDto){

        Task task = new Task();
        task.setTitle(taskPostDto.getTitle());
        task.setOrder(taskPostDto.getOrder());
        task.setComplete(taskPostDto.getComplete());

        Task response = taskService.createTask(task);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/{task-id}")
    public ResponseEntity getTask(@PathVariable("task-id") int taskId){
        Task response = taskService.findTask(taskId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTasks(){
        List<Task> response = taskService.findTasks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{task-id}")
    public ResponseEntity patchTask(@PathVariable("task-id") int taskId,
                                    @RequestBody TaskPatchDto taskPatchDto){
        taskPatchDto.setTaskId(taskId);

        Task task = new Task();
        task.setTaskId(taskPatchDto.getTaskId());
        task.setTitle(taskPatchDto.getTitle());
        task.setOrder(taskPatchDto.getOrder());
        task.setComplete(taskPatchDto.getComplete());

        Task response = taskService.updateTask(task);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity deleteTask(@PathVariable("task-id") int taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

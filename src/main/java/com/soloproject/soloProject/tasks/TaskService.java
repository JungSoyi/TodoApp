package com.soloproject.soloProject.tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    public Task createTask(Task task){

        return taskRepository.save(task);
    }

    public Task updateTask(Task task){
        Task findTask = findVerifiedTask(task.getTaskId());
        Optional.ofNullable(task.getTitle())
                .ifPresent(title -> findTask.setTitle(title));
        Optional.ofNullable(task.getOrders())
                .ifPresent(orders -> findTask.setOrders(orders));
        Optional.ofNullable(task.isComplete())
                .ifPresent(complete -> findTask.setComplete(complete));
        return taskRepository.save(findTask);
    }

    public Task findTask(int taskId){
        return findVerifiedTask(taskId);
    }

    public List<Task> findTasks(){
        return (List<Task>) taskRepository.findAll();
    }

    public void deleteTask(int taskId){
        Task findTask = findVerifiedTask(taskId);

        taskRepository.delete(findTask);

    }

    public Task findVerifiedTask(int taskId){
        Optional<Task> optionalTask =
                taskRepository.findById(taskId);
        Task findTask =
                optionalTask.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TASK_NOT_EXIST));

        return findTask;
    }
}

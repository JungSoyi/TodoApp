package com.soloproject.soloProject.tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    public Task createTask(Task task){
        Task createdTask = task;
        return createdTask;
    }

    public Task updateTask(Task task){
        Task updatedTask = task;
        return updatedTask;
    }

    public Task findTask(int taskId){
        Task task =
                new Task(taskId, "study", 1, true);
        return task;
    }

    public List<Task> findTasks(){
        List<Task> tasks = List.of(
                new Task(1, "study", 1, true)
        );
        return tasks;
    }

    public void deleteTask(int taskId){

    }
}

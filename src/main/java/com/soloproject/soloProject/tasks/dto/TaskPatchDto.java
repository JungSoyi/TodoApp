package com.soloproject.soloProject.tasks.dto;

public class TaskPatchDto {
    private int taskId;
    private String title;
    private int orders;
    private boolean complete;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getOrder(){
        return orders;
    }

    public void setOrder(int order){
        this.orders = orders;
    }

    public boolean getComplete(){
        return complete;
    }

    public void setComplete(){
        this.complete = complete;
    }

    public int getTaskId(){
        return taskId;
    }

    public void setTaskId(int taskId){
        this.taskId = taskId;
    }

}

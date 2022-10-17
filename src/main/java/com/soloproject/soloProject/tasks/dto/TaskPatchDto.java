package com.soloproject.soloProject.tasks.dto;

public class TaskPatchDto {
    private int taskId;
    private String title;
    private int order;
    private boolean complete;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getOrder(){
        return order;
    }

    public void setOrder(int order){
        this.order = order;
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

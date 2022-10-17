package com.soloproject.soloProject.tasks.dto;

public class TaskPostDto {
    private String title;
    private int order;
    private boolean complete;

    public String getTitle(){
        return title;
    }
    public int getOrder(){
        return order;
    }

    public boolean getComplete(){
        return complete;
    }
}



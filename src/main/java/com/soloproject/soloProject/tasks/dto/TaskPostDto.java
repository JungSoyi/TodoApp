package com.soloproject.soloProject.tasks.dto;

public class TaskPostDto {
    private String title;
    private int orders;
    private boolean complete;

    public String getTitle(){
        return title;
    }
    public int getOrder(){
        return orders;
    }

    public boolean getComplete(){
        return complete;
    }
}



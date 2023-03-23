package com.example.todoo.models;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(value = "Todo")
public class Task {
    @Id
    private String id;
    private String task;
    private LocalDate duedate;
    private boolean completed;

    public Task() {
    }


    public Task(String id, String task, boolean completed, LocalDate duedate) {
        this.id = id;
    	this.task = task;
        this.completed = completed;
        this.duedate = duedate;
    }
    public LocalDate getDuedate() {
		return duedate;
	}
	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}


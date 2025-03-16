package org.example.TaskManager;

import java.util.Date;
import java.util.UUID;

public class Task {
    private String taskId;
    private String taskTitle;
    private String taskDetails;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private User assignedTo;
    private Date createdAt;
    private Date reminderDate;
    private Date dueDate;

    public Date getDueDate() {
        return dueDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    Task(String taskTitle, String taskDetails, TaskPriority taskPriority, TaskStatus taskStatus, User assignedTo, Date dueDate){
        this.taskDetails=taskDetails;
        this.taskTitle=taskTitle;
        this.taskPriority=taskPriority;
        this.taskStatus=taskStatus;
        this.assignedTo=assignedTo;
        createdAt=new Date();
        this.dueDate=dueDate;
        this.taskId="TSK-"+ UUID.randomUUID().toString().substring(0,8);
    }
    public void setReminderDate(Date date){
        this.reminderDate=date;
    }
    public void updateTask(){

    }
}

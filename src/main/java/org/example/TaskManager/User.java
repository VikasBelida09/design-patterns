package org.example.TaskManager;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private String userId;
    private String userName;
    private List<Task> taskList;

    public List<Task> getTaskList() {
        return taskList;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    User(String name){
        this.userName=name;
        taskList=new CopyOnWriteArrayList<>();
        this.userId="USR-"+ UUID.randomUUID().toString().substring(0,8);
    }
    void assignTask(Task task){
        this.taskList.add(task);
        System.out.println("Assigned task: "+ task);
    }
    void removeTask(Task task){
        this.taskList.remove(task);
    }
    void getReminder(String message){
        System.out.println(message);
    }
}

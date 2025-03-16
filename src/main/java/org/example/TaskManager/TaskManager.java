package org.example.TaskManager;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class TaskManager {
    private static volatile TaskManager instance;
    private final Map<String, Task> tasks;
    private final Map<String, User>users;
    private ScheduledExecutorService scheduledExecutorService;

    private TaskManager(){
        tasks=new ConcurrentHashMap<>();
        users=new ConcurrentHashMap<>();
        scheduledExecutorService= Executors.newScheduledThreadPool(1);
        scheduleReminderService();
    }
    public static TaskManager getInstance(){
        if(instance==null){
            synchronized (TaskManager.class){
                if(instance==null){
                    instance=new TaskManager();
                }
            }
        }
        return instance;
    }
    public User addUser(String name){
        User user=new User(name);
        users.put(user.getUserId(),user);
        return user;
    }
    public Task createTask(String taskTitle, String taskDetails, TaskPriority taskPriority, TaskStatus taskStatus, User assignedTo,Date dueDate){
        Task task=new Task(taskTitle, taskDetails, taskPriority, taskStatus, assignedTo,dueDate);
        tasks.put(task.getTaskId(),task);
        return task;
    }
    public List<Task> searchTaskByKeyword(String keyword){
        return tasks
                .values()
                .stream()
                .filter(t->t.getTaskDetails().toLowerCase().contains(keyword.toLowerCase()) || t.getTaskDetails().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
    public void scheduleReminderService(){
        scheduledExecutorService.scheduleAtFixedRate(()->{
            Date now=new Date();
            for (Task task : tasks.values()) {
                if (task.getReminderDate() != null && task.getReminderDate().before(now) && task.getTaskStatus() == TaskStatus.PENDING) {
                    System.out.println("[Reminder] Task: " + task.getTaskTitle() + " is due on " + task.getDueDate());
                }
            }
        },0,1, TimeUnit.MINUTES);
    }
}

package org.example.RideSharingService;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements Notifiable {
    private String name;
    private String email;
    private String userId;

    private List<NotificationStrategy>notificationStrategies;

    public User(String name, String email){
        this.email=email;
        this.name=name;
        this.notificationStrategies=new ArrayList<>();
    }
    public void addNotification(NotificationStrategy strategy){
        this.notificationStrategies.add(strategy);
    }
    public void receiveNotification(String message){
        for(NotificationStrategy strategy:notificationStrategies){
            strategy.sendNotificaiton(message, this);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }
}

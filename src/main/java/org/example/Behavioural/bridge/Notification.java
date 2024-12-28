package org.example.Behavioural.bridge;

public abstract class Notification {
    protected NotificationChannel notificationChannel;
    public Notification(NotificationChannel channel){
        this.notificationChannel=channel;
    }
    abstract void sendNotification(String message);
}

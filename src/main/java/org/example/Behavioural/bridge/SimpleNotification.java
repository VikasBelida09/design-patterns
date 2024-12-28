package org.example.Behavioural.bridge;

public class SimpleNotification extends Notification{
    public SimpleNotification(NotificationChannel channel){
        super(channel);
    }
    @Override
    void sendNotification(String message) {
        System.out.println("[SIMPLE] Notification");
        notificationChannel.sendMessage(message);
    }
}

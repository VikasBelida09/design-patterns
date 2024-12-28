package org.example.Behavioural.bridge;

public class UrgentNotification extends Notification{
    public UrgentNotification(NotificationChannel channel){
        super(channel);
    }
    @Override
    void sendNotification(String message) {
        System.out.println("[URGENT] Notification");
        notificationChannel.sendMessage(message);
    }
}

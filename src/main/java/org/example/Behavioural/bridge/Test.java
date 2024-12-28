package org.example.Behavioural.bridge;

public class Test {
    public static void main(String[] args) {
        NotificationChannel channel=new EmailChannel();
        UrgentNotification notification=new UrgentNotification(channel);
        notification.sendNotification("this is a test notification!");
        SimpleNotification notification1=new SimpleNotification(channel);
        notification1.sendNotification("this is another test notification");
    }
}

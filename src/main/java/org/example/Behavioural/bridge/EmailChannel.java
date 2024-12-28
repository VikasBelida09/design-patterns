package org.example.Behavioural.bridge;

public class EmailChannel implements NotificationChannel{
    @Override
    public void sendMessage(String message) {
        System.out.println("[EMAIL]: "+message);
    }
}

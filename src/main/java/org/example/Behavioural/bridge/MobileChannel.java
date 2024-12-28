package org.example.Behavioural.bridge;

public class MobileChannel implements NotificationChannel{
    @Override
    public void sendMessage(String message) {
        System.out.println("[PHONE]: "+message);
    }
}

package org.example.RideSharingService;

public interface NotificationStrategy {
    void sendNotificaiton(String message, User user);
}

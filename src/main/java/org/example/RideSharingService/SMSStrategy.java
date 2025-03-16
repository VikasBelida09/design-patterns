package org.example.RideSharingService;

public class SMSStrategy implements NotificationStrategy{
    @Override
    public void sendNotificaiton(String message, User user) {
        System.out.println("SMS: "+ message+" to user: "+ user.getName());
    }
}

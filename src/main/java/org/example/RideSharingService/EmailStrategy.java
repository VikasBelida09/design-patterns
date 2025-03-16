package org.example.RideSharingService;

public class EmailStrategy implements NotificationStrategy{
    @Override
    public void sendNotificaiton(String message, User user) {
        System.out.println("EMAIL: "+ message+" to user: "+user.getName());
    }
}

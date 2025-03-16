package org.example.OnlineAuction;

public class Bidder extends User implements Notifiable{
    public Bidder(String name, String password) {
        super(name, password);
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println(message);
    }
}

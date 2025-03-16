package org.example.RideSharingService;

public class Driver extends User{
    boolean isAvailable;
    public Driver(String name, String email) {
        super(name, email);
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

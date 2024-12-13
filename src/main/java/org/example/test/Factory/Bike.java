package org.example.test.Factory;

public class Bike implements Vehicle{
    @Override
    public int getFuelCapacity() {
        return 200;
    }

    @Override
    public int milesCovered() {
        return 3000;
    }

    @Override
    public void honk() {
        System.out.println("Vehicle honked");
    }
}

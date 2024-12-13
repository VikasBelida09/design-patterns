package org.example.test.Factory;

public class Car implements Vehicle{
    @Override
    public int getFuelCapacity() {
        return 400;
    }

    @Override
    public int milesCovered() {
        return 6000;
    }

    @Override
    public void honk() {
        System.out.println("Car Honked!");
    }
}

package org.example.creational.Factory;

public class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("driving Bike");
    }

    @Override
    public void getTankCapacity() {
        System.out.println("driving Car");
    }
}

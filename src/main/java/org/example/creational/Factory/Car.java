package org.example.creational.Factory;

public class Car implements Vehicle{

    @Override
    public void drive() {
        System.out.println("driving car");
    }

    @Override
    public void getTankCapacity() {
        System.out.println("tank capacity is 100ltrs");
    }
}

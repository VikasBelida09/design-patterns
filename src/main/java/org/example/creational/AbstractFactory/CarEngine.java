package org.example.creational.AbstractFactory;

public class CarEngine implements Engine{
    @Override
    public void start() {
        System.out.println("starting car engine");
    }
}

package org.example;

import org.example.creational.AbstractFactory.AbstractFactory;
import org.example.creational.AbstractFactory.Engine;
import org.example.creational.AbstractFactory.FactoryProducer;
import org.example.creational.AbstractFactory.Vehicle;
import org.example.creational.Factory.VehicleFactory;
import org.example.creational.Singleton;
import org.example.structural.Coffee;
import org.example.structural.MilkDecorator;
import org.example.structural.SimpleCoffe;
import org.example.structural.SugarDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton1==singleton);

//        factory example
//        Vehicle vehicle=VehicleFactory.getVehicle("CAR");
//        vehicle.drive();

        //abstract factory example

        AbstractFactory<Vehicle> vehicleAbstractFactory= (AbstractFactory<Vehicle>) FactoryProducer.getFactory("VEHICLE");
        Vehicle car=vehicleAbstractFactory.create("CAR");
        car.drive();

        AbstractFactory<Engine> engineAbstractFactory= (AbstractFactory<Engine>) FactoryProducer.getFactory("ENGINE");
        Engine engine=engineAbstractFactory.create("CARENGINE");
        engine.start();

        // decorator pattern
        SimpleCoffe simpleCoffe=new SimpleCoffe();
        Coffee sugarAndMilk=new SugarDecorator(new MilkDecorator(simpleCoffe));
        System.out.println(sugarAndMilk.getDescription());
        System.out.println(sugarAndMilk.getCost());

    }
}
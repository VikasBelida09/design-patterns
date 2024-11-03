package org.example.creational.AbstractFactory;

public class VehicleFactory implements AbstractFactory<Vehicle>{
    public Vehicle create(String type){
        return switch (type){
            case "CAR" -> new Car();
            case "BIKE" -> new Bike();
            default -> null;
        };
    }
}

package org.example.test.Factory;

public class ConcreteVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle getVehicle(String type) {
        return switch (type){
            case "CAR" -> new Car();
            case "BIKE" -> new Bike();
            default -> throw new RuntimeException("Invalid type chosen!");
        };
    }
}

package org.example.creational.Factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        return switch (vehicleType) {
            case "BIKE" -> new Bike();
            case "CAR" -> new Car();
            default -> null;
        };
    }
}

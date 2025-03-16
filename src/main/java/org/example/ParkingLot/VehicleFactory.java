package org.example.ParkingLot;

public class VehicleFactory {
    public static Vehicle createVehicle(String licensePlate, VehicleType vehicleType){
        return new Vehicle(licensePlate, vehicleType);
    }
}

package org.example.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingFloor {
    List<ParkingSpot>parkingSpots;
    int floor;
    private final Random random=new Random();
    ParkingFloor(int floor, int spotsPerFloor){
        parkingSpots=new ArrayList<>();
        initializeRandomParkingSpots(spotsPerFloor);
        this.floor=floor;
    }
    private void initializeRandomParkingSpots(int spotsPerFloor){
        for(int i = 0; i< spotsPerFloor; i++){
            int vehicleIndex=random.nextInt(VehicleType.values().length);
            VehicleType vehicleType=VehicleType.values()[vehicleIndex];
            parkingSpots.add(new ParkingSpot(i+1, vehicleType));
        }
    }
    public ParkingSpot allocateSpot(Vehicle vehicle){
        for(ParkingSpot spot: parkingSpots){
            if(!spot.isOccupied && spot.parkingSpotType==vehicle.vehicleType)return spot;
        }
        return null;
    }
    public void freeSpot(ParkingSpot spot){
        spot.freeSpot();
    }
}

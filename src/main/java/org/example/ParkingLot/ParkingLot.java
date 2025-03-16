package org.example.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloors;
    PaymentService paymentService;
    Map<String, Ticket> tickets=new ConcurrentHashMap<>();
    private static ParkingLot instance;
    public ParkingLot(int numFloors, int spotsPerFloor){
        parkingFloors=new ArrayList<>();
        for(int i=0;i<numFloors;i++){
            ParkingFloor parkingFloor=new ParkingFloor(i+1, spotsPerFloor);
            parkingFloors.add(parkingFloor);
        }
        paymentService=new PaymentService();
    }
    public static synchronized ParkingLot getInstance(int numFloors, int numParkingSpots){
        if(instance==null){
            instance=new ParkingLot(numFloors, numParkingSpots);
        }
        return instance;
    }
    public Ticket parkVehicle(Vehicle vehicle){

        System.out.println("no parking spot available");
        return null;
    }
    public double removeVehicle(Ticket ticket){
        if(tickets.containsKey(ticket.getTicketId())){
            ticket.getSpot().freeSpot();
            return paymentService.calculateFee(ticket);
        }
        return 0;
    }
}

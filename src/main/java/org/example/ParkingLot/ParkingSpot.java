package org.example.ParkingLot;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpot {
    VehicleType parkingSpotType;
    boolean isOccupied;
    int number;
    Lock lock= new ReentrantLock();

    ParkingSpot(int number, VehicleType type){
        this.parkingSpotType=type;
        this.isOccupied=false;
        this.number=number;
    }
    public boolean assignSpot(){
        if(lock.tryLock()){
            try{
                if(!isOccupied){
                    isOccupied=true;
                    return true;
                }
            }finally{
                lock.unlock();
            }
        }
        return false;
    }
    public void freeSpot(){
        lock.lock();
        try{
            isOccupied=false;
        }finally{
            lock.unlock();
        }
    }
}

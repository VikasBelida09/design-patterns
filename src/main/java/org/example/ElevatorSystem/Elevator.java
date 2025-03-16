package org.example.ElevatorSystem;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class Elevator implements Runnable{
    private final int elevatorId;
    private int currentFloor;
    private Direction direction;

    private final NavigableSet<Integer>stops;

    public Elevator(int elevatorId, int initialFloor){
        this.direction=Direction.IDLE;
        stops=new ConcurrentSkipListSet<>();
        this.currentFloor=initialFloor;
        this.elevatorId=elevatorId;
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try{
                Integer nextStop=null;
                synchronized (this){
                    if(!stops.isEmpty()){
                        if(direction == Direction.UP){
                            nextStop = stops.ceiling(currentFloor+1);
                            if(nextStop==null){
                                direction=Direction.DOWN;
                                nextStop=stops.floor(currentFloor-1);
                            }
                        }else if(direction==Direction.DOWN){
                            nextStop=stops.floor(currentFloor-1);
                            if(nextStop==null){
                                direction=Direction.UP;
                                nextStop=stops.ceiling(currentFloor+1);
                            }
                        }
                        if(nextStop!=null){
                            System.out.println("Elevator "+elevatorId+" moving from floor "+currentFloor+" to "+nextStop);
                        }
                    }else{
                        direction=Direction.IDLE;
                    }
                }
                if(nextStop!=null){
                    int travelTime=Math.abs(nextStop-currentFloor)*500; // 500ms latency per floor
                    Thread.sleep(travelTime);
                    synchronized (this){
                        currentFloor=nextStop;
                        stops.remove(nextStop);
                        System.out.println("Elevator "+elevatorId+" arrived at floor "+ currentFloor);
                    }
                }else{
                    Thread.sleep(200);
                }
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
                System.out.println("Elevator "+ elevatorId+"  shutting down.");
            }
        }
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public synchronized int getCurrentFloor() {
        return currentFloor;
    }

    public synchronized Direction getDirection() {
        return direction;
    }
    public synchronized void addStop(int stop){
        stops.add(stop);
        if(direction==Direction.IDLE){
            if(stop > currentFloor){
                this.direction=Direction.UP;
            }else if(stop<currentFloor){
                this.direction=Direction.DOWN;
            }
        }
    }

}

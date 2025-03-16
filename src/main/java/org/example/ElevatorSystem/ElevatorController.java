package org.example.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ElevatorController {
    private final List<Elevator> elevators;
    private final BlockingQueue<ElevatorRequest>requestQueue;

    private final ExecutorService elevatorExecutor;
    private final ExecutorService controllerExecutor;

    public ElevatorController(int numberOfElevators, int initialFloor){
        this.elevators=new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            Elevator elevator=new Elevator(i+1,initialFloor);
            elevators.add(elevator);
        }
        this.requestQueue=new LinkedBlockingQueue<>();
        this.elevatorExecutor= Executors.newFixedThreadPool(numberOfElevators);
        this.controllerExecutor=Executors.newSingleThreadExecutor();
    }
    public void start(){
        elevators.forEach(elevatorExecutor::submit);
        controllerExecutor.submit(()->{
           while(!Thread.currentThread().isInterrupted()){
               try{
                   ElevatorRequest request=requestQueue.take();
                   assignRequestToElevator(request);
               }catch(InterruptedException ex){
                   Thread.currentThread().interrupt();
                   System.out.println("Elevator controller shutting down");
                   break;
               }
           }
        });
    }
    public void submitRequest(ElevatorRequest request){
        this.requestQueue.add(request);
    }
    private void assignRequestToElevator(ElevatorRequest elevatorRequest){
        Elevator best=null;
        int minDistance=Integer.MAX_VALUE;
        for(Elevator elevator:elevators){
            int distance=Math.abs(elevator.getCurrentFloor()- elevatorRequest.getSourceFloor());
            if(minDistance > distance){
                minDistance=distance;
                best=elevator;
            }
        }
        if(best!=null){
            best.addStop(elevatorRequest.getSourceFloor());
            best.addStop(elevatorRequest.getDestinationFloor());
            System.out.println("Assigning request "+ elevatorRequest + "to elevator "+ best.getElevatorId());
        }
    }
    public void shutdown(){
        elevatorExecutor.shutdown();
        controllerExecutor.shutdown();
    }
    public void shutdownGracefully(){
        elevatorExecutor.shutdown();
        controllerExecutor.shutdown();
        try{
            if(!elevatorExecutor.awaitTermination(60, TimeUnit.SECONDS)){
                elevatorExecutor.shutdownNow();
            }
            if(!controllerExecutor.awaitTermination(60, TimeUnit.SECONDS)){
                controllerExecutor.shutdownNow();
            }
        }catch(InterruptedException ex){
            elevatorExecutor.shutdownNow();
            controllerExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

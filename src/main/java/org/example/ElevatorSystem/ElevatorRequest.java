package org.example.ElevatorSystem;

public class ElevatorRequest {
    private int sourceFloor;
    private int destinationFloor;
    private long requestedTimestamp;

    public ElevatorRequest(int sourceFloor, int destinationFloor, long requestedTimestamp){
        this.sourceFloor=sourceFloor;
        this.destinationFloor=destinationFloor;
        this.requestedTimestamp=requestedTimestamp;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public long getRequestedTimestamp() {
        return requestedTimestamp;
    }
}

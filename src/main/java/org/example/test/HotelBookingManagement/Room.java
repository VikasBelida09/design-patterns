package org.example.test.HotelBookingManagement;

public class Room {
    private final RoomType roomType;
    private final String roomId;
    private RoomStatus roomStatus;

    private final double price;
    public Room(RoomType type, String id, double price){
        this.roomType=type;
        this.roomId=id;
        this.price=price;
        this.roomStatus=RoomStatus.AVAILABLE;
    }
    public synchronized void bookRoom(){
        if(roomStatus==RoomStatus.AVAILABLE){
            this.roomStatus=RoomStatus.BOOKED;
        }else{
            throw new IllegalStateException("Room is not available for booking.");
        }
    }
    public synchronized void checkIn(){
        if(roomStatus==RoomStatus.BOOKED){
            this.roomStatus=RoomStatus.OCCUPIED;
        }else{
            throw new IllegalStateException("Room is not booked to checkin.");
        }
    }
    public synchronized void checkOut(){
        if(roomStatus==RoomStatus.OCCUPIED){
            this.roomStatus=RoomStatus.AVAILABLE;
        }else{
            throw new IllegalStateException("Room is not occupied to checkout.");
        }
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public double getPrice() {
        return price;
    }
}

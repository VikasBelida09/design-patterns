package org.example.test.BookMyShow;

import java.util.UUID;

public class Seat {
    private char level;
    private int number;
    private String seatId;

    private SeatStatus status;
    public Seat(char level, int number){
        this.level=level;
        this.number=number;
        this.status=SeatStatus.AVAILABLE;
        this.seatId="SEAT"+ UUID.randomUUID().toString().substring(0,4);
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
    public boolean bookSeat(){
        synchronized (Seat.class){
            if(this.getStatus()==SeatStatus.AVAILABLE){
                this.status=SeatStatus.RESERVED;
                return true;
            }
        }
        return false;
    }
    public boolean isAvailable(){
        return status==SeatStatus.AVAILABLE;
    }
}

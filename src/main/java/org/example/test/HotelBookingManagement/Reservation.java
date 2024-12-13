package org.example.test.HotelBookingManagement;

import java.time.LocalDate;

public class Reservation {
    private Room roomDetails;
    private ReservationType reservationType;
    private Guest guestDetails;
    private String reservationId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Room roomDetails, Guest guestDetails, String reservationId, LocalDate startDate, LocalDate endDate) {
        this.roomDetails = roomDetails;
        this.reservationType = ReservationType.CONFIRMED;
        this.guestDetails = guestDetails;
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public synchronized void cancel(){
        if(this.reservationType==ReservationType.CONFIRMED){
            this.reservationType=ReservationType.CANCELLED;
        }else{
            throw new IllegalStateException("Reservation is not confirmed to cancel");
        }
    }
    public Room getRoomDetails() {
        return roomDetails;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public Guest getGuestDetails() {
        return guestDetails;
    }

    public String getReservationId() {
        return reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}

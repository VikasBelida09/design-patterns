package org.example.test.HotelBookingManagement;


import org.example.test.HotelBookingManagement.Payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private final Map<String, Room> rooms;
    private final Map<String, Guest> guests;
    private final Map<String, Reservation> reservations;

    public HotelManagementSystem(){
        rooms=new ConcurrentHashMap<>();
        guests=new ConcurrentHashMap<>();
        reservations=new ConcurrentHashMap<>();
    }
    public static synchronized HotelManagementSystem getInstance(){
        if(instance==null){
            instance=new HotelManagementSystem();
        }
        return instance;
    }
    public void addGuest(Guest guest){
        guests.put(guest.getId(), guest);
    }
    public void addRoom(Room room){
        rooms.put(room.getRoomId(), room);
    }
    public void addReservation(Reservation reservation){
        reservations.put(reservation.getReservationId(), reservation);
    }
    public synchronized Reservation bookRoom(Room room, Guest guest, LocalDate checkIn, LocalDate checkOut){
        Reservation reservation=null;
        if(room.getRoomStatus()==RoomStatus.AVAILABLE){
            room.bookRoom();
            String reservationId=this.generateReservationId();
            reservation=new Reservation(room, guest, reservationId,checkIn, checkOut);
            this.addReservation(reservation);
            System.out.println("Room:"+room.getRoomId()+ " booked by: "+guest.getName() +" and this is the reservation id:"+ reservation.getReservationId());
        }
        return reservation;
    }
    public synchronized void checkIn(String reservationId){
        Reservation reservation=this.reservations.get(reservationId);
        if(reservation!=null && reservation.getReservationType()==ReservationType.CONFIRMED){
            Room room=reservation.getRoomDetails();
            room.checkIn();
            System.out.println("Room:"+room.getRoomId()+ " checked in by: "+reservation.getGuestDetails().getName());
        }else{
            throw new IllegalStateException("Invalid reservation or reservation not confirmed");
        }
    }
    public synchronized void checkOut(String reservationId, Payment payment){
        Reservation reservation=this.reservations.get(reservationId);
        if(reservation!=null && reservation.getReservationType()==ReservationType.CONFIRMED){
            Room room=reservation.getRoomDetails();
            double amount=room.getPrice() * ChronoUnit.DAYS.between(reservation.getStartDate(),reservation.getEndDate());
            if(payment.makePayment(amount)){
                room.checkOut();
                reservations.remove(reservationId);
                System.out.println("Room:"+room.getRoomId()+ " checked out by: "+reservation.getGuestDetails().getName());
            }else{
                throw new IllegalStateException("Payment failed");
            }
        }else{
            throw new IllegalStateException("Invalid Reservation or reservation not confirmed");
        }
    }
    public synchronized void cancelReservation(String reservationId){
        Reservation reservation=this.reservations.get(reservationId);
        if(reservation!=null)reservation.cancel();
    }
    private String generateReservationId(){
        return "RES"+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}

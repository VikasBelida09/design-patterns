package org.example.test.HotelBookingManagement;

import org.example.test.HotelBookingManagement.Payment.CashPayment;

import java.time.LocalDate;
import java.util.List;

public class HotelManagementDemo {
    public static void main(String args[]){
        HotelManagementSystem hotelManagementSystem=HotelManagementSystem.getInstance();

        //guests
        Guest guest1=new Guest("dhoni","7568761234","12343123",null,"dhoni@gmail.com","G001");
        Guest guest2=new Guest("virat","1234567890","231231231",null,"virat@gmail.com","G002");

        //rooms
        Room room1=new Room(RoomType.DELUXE,"R0001",100.0);
        Room room2=new Room(RoomType.SINGLE, "R0002",80.0);

        hotelManagementSystem.addGuest(guest1);
        hotelManagementSystem.addGuest(guest2);

        hotelManagementSystem.addRoom(room1);
        hotelManagementSystem.addRoom(room2);

        LocalDate checkIn=LocalDate.now();
        LocalDate checkoutDate=checkIn.plusDays(3);

        Reservation rs1=hotelManagementSystem.bookRoom(room1,guest1,checkIn,checkoutDate);
        hotelManagementSystem.checkIn(rs1.getReservationId());
        hotelManagementSystem.checkOut(rs1.getReservationId(), new CashPayment());
    }
}

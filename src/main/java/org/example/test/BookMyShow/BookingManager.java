package org.example.test.BookMyShow;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookingManager {
    private final Map<String, List<Booking>>userBookings;
    public BookingManager(){
        userBookings=new ConcurrentHashMap<>();
    }
    public void addUserBooking(Customer customer, Booking booking){
        this.userBookings.computeIfAbsent(customer.getEmail(),k->new CopyOnWriteArrayList<>()).add(booking);
    }
    public List<Booking> getUserBookings(Customer customer){
        return this.userBookings.getOrDefault(customer.getEmail(), new CopyOnWriteArrayList<>());
    }
    public boolean cancelBooking(Booking bookingRef){
        if(Objects.isNull(bookingRef) || bookingRef.getShow().getShowStartDate().isBefore(LocalDate.now()) || !bookingRef.isBookingCancellable()) return false;
        bookingRef.cancelBooking();
        List<Booking>bookings=this.getUserBookings(bookingRef.getCustomer());
        Optional<Booking>bookingToBeCancelled=bookings.stream().filter(booking->booking.getBookingId().equals(bookingRef.getBookingId()) && booking.isBookingCancellable()).findAny();
        bookingToBeCancelled.ifPresent(Booking::cancelBooking);
        return bookingToBeCancelled.isPresent();
    }
    public Booking bookShow(Show s, List<Seat>seats, Customer customer){
        if(Objects.isNull(s) || Objects.isNull(seats) || Objects.isNull(customer))return null;
        boolean allSeatsAvailable=seats.stream().allMatch(Seat::isAvailable);
        if(!allSeatsAvailable) return null;
        seats.forEach(Seat::bookSeat);
        return new Booking(customer,s.getTheatre(),s.getScreen(),s);
    }
}

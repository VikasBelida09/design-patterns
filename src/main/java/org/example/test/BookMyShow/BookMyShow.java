package org.example.test.BookMyShow;

import org.example.test.BookMyShow.Payment.Payment;

import java.time.LocalDate;
import java.util.List;


public class BookMyShow {
    private final BookingManager bookingManager;
    private final TheatreManager theatreManager;
    private static volatile BookMyShow instance;
    private BookMyShow(){
        bookingManager=new BookingManager();
        theatreManager=new TheatreManager();
    }
    public static BookMyShow getInstance(){
        if(instance==null){
            synchronized (BookMyShow.class){
                if(instance==null){
                    instance=new BookMyShow();
                }
            }
        }
        return instance;
    }
    public List<Show> findShowsByMovieName(String movieName){
        return this.theatreManager.getShowsByMovieName(movieName);
    }
    public List<Show> findShowsByShowStartDate(LocalDate date){
        return this.theatreManager.getShowsByStartDate(date);
    }
    public List<Theatre> findTheatresByTheatreName(String name){
        return this.theatreManager.getTheatreList(name);
    }
    public List<Theatre> findTheatresByLocation(String pinCode){
        return this.theatreManager.getTheatreListByLocation(pinCode);
    }

    public Booking bookShow(Show s, List<Seat>seats, Customer customer){
      return this.bookingManager.bookShow(s,seats,customer);
    }
    public boolean makePayment(Booking bookingRef, Payment payment){
        double totalPrice=bookingRef.getShow().getPrice() * bookingRef.getSeatList().size();
        if(payment.processPayment(totalPrice)){
            bookingRef.setPaymentDetails(payment);
            bookingRef.setStatus(BookingStatus.CONFIRMED);
            bookingManager.addUserBooking(bookingRef.getCustomer(),bookingRef);
        }
        return true;
    }
    public boolean cancelBooking(Booking bookingRef){
       return this.bookingManager.cancelBooking(bookingRef);
    }
}

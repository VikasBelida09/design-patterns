package org.example.test.BookMyShow;

import org.example.test.BookMyShow.Payment.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking {
    private Customer customer;
    private List<Seat> seatList;
    private Theatre theatre;
    private Show show;
    private Screen screen;
    private BookingStatus status;
    private String bookingId;
    private LocalDate bookingCreatedAt;
    private LocalDate bookingUpdatedAt;
    private Payment paymentDetails;
    public Booking(Customer customer,Theatre theatre,Screen screen,Show show){
        this.bookingId="BKNG-"+ UUID.randomUUID().toString().substring(0,8);
        seatList=new ArrayList<>();
        this.customer=customer;
        this.theatre=theatre;
        this.screen=screen;
        this.show=show;
        this.status=BookingStatus.PENDING;
        this.bookingCreatedAt=LocalDate.now();
        this.bookingUpdatedAt=LocalDate.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getBookingCreatedAt() {
        return bookingCreatedAt;
    }

    public void setBookingCreatedAt(LocalDate bookingCreatedAt) {
        this.bookingCreatedAt = bookingCreatedAt;
    }

    public LocalDate getBookingUpdatedAt() {
        return bookingUpdatedAt;
    }

    public void setBookingUpdatedAt(LocalDate bookingUpdatedAt) {
        this.bookingUpdatedAt = bookingUpdatedAt;
    }

    public Payment getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Payment paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
    public boolean cancelBooking(){
        if(this.status==BookingStatus.CANCELLED) return false;
        this.status=BookingStatus.CANCELLED;
        return true;
    }
    public boolean isBookingCancellable(){
        return this.status != BookingStatus.CANCELLED;
    }
}

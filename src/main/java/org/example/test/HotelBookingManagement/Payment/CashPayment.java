package org.example.test.HotelBookingManagement.Payment;

public class CashPayment implements Payment{
    @Override
    public boolean makePayment(double price) {
        System.out.println("Payment "+price+" made successfully in cash:");
        return true;
    }
}

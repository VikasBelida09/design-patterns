package org.example.RideSharingService;

public interface PaymentAdapter {
    void processPayment(Ride ride, double amnt);
}

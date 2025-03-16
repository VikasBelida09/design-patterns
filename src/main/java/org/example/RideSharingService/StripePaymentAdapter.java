package org.example.RideSharingService;

public class StripePaymentAdapter implements PaymentAdapter{
    @Override
    public void processPayment(Ride ride, double amnt) {
        System.out.println("Processing payment of $"+ amnt+" for ride "+ride+" via stripe");
    }
}

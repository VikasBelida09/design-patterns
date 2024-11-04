package org.example.structural.Adapter;

public class PaypalAdapter implements PaymentProcessor{
    private final Paypal paypal;
    public PaypalAdapter(Paypal paypal){
        this.paypal=paypal;
    }
    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

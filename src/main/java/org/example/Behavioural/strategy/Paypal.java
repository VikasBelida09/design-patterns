package org.example.Behavioural.strategy;

public class Paypal implements PaymentStrategy{
    private String email;
    public Paypal(String email){
        this.email=email;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Payment made using "+amount+" using paypal - email "+ email);
    }
}

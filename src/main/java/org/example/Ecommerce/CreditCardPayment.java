package org.example.Ecommerce;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public boolean pay(Order order, double amnt) {
        System.out.println("Processing using CreditCard!");
        return false;
    }
}

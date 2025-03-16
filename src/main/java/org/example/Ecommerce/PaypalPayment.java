package org.example.Ecommerce;

public class PaypalPayment implements PaymentMethod{
    @Override
    public boolean pay(Order order, double amnt) {
        return false;
    }
}

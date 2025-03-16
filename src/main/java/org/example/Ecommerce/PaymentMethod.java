package org.example.Ecommerce;

public interface PaymentMethod {
    boolean pay(Order order, double amnt);
}

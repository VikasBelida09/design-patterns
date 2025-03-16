package org.example.Ecommerce;

public interface IOrder {
    int getQuantity();
    int getAvailableQuantity();
    String getDescription();
    double getTotalPrice();
}

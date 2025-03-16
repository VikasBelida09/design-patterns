package org.example.Ecommerce;

public class Order {
    private final IOrder order;

    public Order(IOrder order) {
        this.order = order;
    }

    public double getTotalPrice() {
        return order.getTotalPrice();
    }

    public int getQuantity() {
        return order.getQuantity();
    }

    public int getAvailableQuantity() {
        return order.getAvailableQuantity();
    }

    public String getDescription() {
        return order.getDescription();
    }
}
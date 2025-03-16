package org.example.Ecommerce;

public class BaseOrder implements IOrder{
    private final double basePrice;
    private final String description;
    private final int quantity;
    private final int availableQuantity; // Simulate stock

    public BaseOrder(double basePrice, String description, int quantity, int availableQuantity) {
        this.basePrice = basePrice;
        this.description = description;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
    }
    @Override
    public double getTotalPrice() {
        return basePrice * quantity;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getAvailableQuantity() {
        return availableQuantity;
    }
}

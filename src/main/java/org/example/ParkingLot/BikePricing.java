package org.example.ParkingLot;

public class BikePricing implements PricingStrategy{
    @Override
    public double calculateFee(int hrs) {
        return hrs * 5;
    }
}

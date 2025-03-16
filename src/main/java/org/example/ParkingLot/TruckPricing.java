package org.example.ParkingLot;

public class TruckPricing implements PricingStrategy{
    @Override
    public double calculateFee(int hrs) {
        return hrs* 20;
    }
}

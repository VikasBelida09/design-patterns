package org.example.ParkingLot;

public class CarPricing implements PricingStrategy{
    @Override
    public double calculateFee(int hrs) {
        int CAR_PARKING_PRICE = 10;
        return hrs * CAR_PARKING_PRICE;
    }
}

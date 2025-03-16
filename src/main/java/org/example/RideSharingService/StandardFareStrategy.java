package org.example.RideSharingService;

public class StandardFareStrategy implements FareCalculationStrategy{
    private static final double BASE_FARE=5.0;
    private static final double PER_MILE_RATE=2.0;

    @Override
    public double calculateFare(Ride ride) {
        return 1;
    }
}

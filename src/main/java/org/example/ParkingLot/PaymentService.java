package org.example.ParkingLot;

import java.util.Date;

class PaymentService {
    public double calculateFee(Ticket ticket) {
        PricingStrategy pricing=getPricingStrategy(ticket.getVehicle().vehicleType);
        return pricing.calculateFee((int) ((new Date().getTime() - ticket.getEntryTime().getTime())/1000*60*60)+1);
    }
    public PricingStrategy getPricingStrategy(VehicleType type){
      return switch(type){
          case CAR -> new CarPricing();
          case BIKE -> new BikePricing();
          case TRUCK -> new TruckPricing();
      };
    }
}
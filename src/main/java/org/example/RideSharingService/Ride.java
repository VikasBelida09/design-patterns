package org.example.RideSharingService;


import java.util.concurrent.locks.ReentrantLock;

public class Ride {
    Rider rider;
    Driver driver;
    int rideId;
    private Location pickup;
    private Location dropOff;
    private RideStatus rideStatus;
    private double fare;
    private FareCalculationStrategy fareCalculationStrategy;
    private ReentrantLock lock;
    private PaymentAdapter paymentAdapter;
    private double dist;
   public Ride(Rider rider, Location pickup, Location dropOff, FareCalculationStrategy fareCalculationStrategy, PaymentAdapter paymentAdapter){
        this.rider=rider;
        this.pickup=pickup;
        this.dropOff=dropOff;
        this.fareCalculationStrategy=fareCalculationStrategy;
        this.paymentAdapter=paymentAdapter;
        this.rideStatus=RideStatus.REQUESTED;
        lock=new ReentrantLock();
        this.dist=calculateDistance(pickup, dropOff);
   }
    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getRideId() {
        return rideId;
    }

    public Location getPickup() {
        return pickup;
    }

    public Location getDropOff() {
        return dropOff;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public double getFare() {
        return fare;
    }

    public FareCalculationStrategy getFareCalculationStrategy() {
        return fareCalculationStrategy;
    }
    private double calculateDistance(Location pickup, Location dropOff){
       double dLat= dropOff.getLat()-pickup.getLat();
       double dLon=dropOff.getLon()- pickup.getLon();
       return Math.sqrt(dLat*dLat + dLon*dLon);
    }
    public void assignDriver(Driver driver){
       lock.lock();
       try{
          if(rideStatus==RideStatus.REQUESTED){
              this.driver=driver;
              rideStatus=RideStatus.ASSIGNED;
              rider.receiveNotification("Driver: "+driver+" has been assigned for your ride:");
              driver.receiveNotification("You have been assigned to ride "+rideId+" for Rider: "+rider.getName());
          }
       }finally{
           lock.unlock();
       }
    }
    public void startRide(){
       lock.lock();
       try{
           if(rideStatus == RideStatus.ASSIGNED){
               rideStatus=RideStatus.IN_PROGRESS;
                rider.receiveNotification("Your ride "+ rideId +"has been started");
                driver.receiveNotification("Your ride "+ rideId +"has been started");
           }
       }finally {
          lock.unlock();
       }
    }
    public void completeRide(){
        lock.lock();
        try{
            if(rideStatus==RideStatus.IN_PROGRESS){
                rideStatus=RideStatus.COMPLETED;
                fare=fareCalculationStrategy.calculateFare(this);
                rideStatus=RideStatus.COMPLETED;
                rider.receiveNotification("Your ride "+rideId+" has ended. Fare: $"+fare);
                driver.receiveNotification("Your ride " + rideId + " has ended.");
                paymentAdapter.processPayment(this, fare);
            }
        }finally{
            lock.unlock();
        }
        if(driver!=null){
            driver.setAvailable(true);
        }
    }
}

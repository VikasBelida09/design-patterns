package org.example.RideSharingService;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DispatchService {
    private static volatile DispatchService instance;
    private List<Driver> availableDrivers;
    private ExecutorService executorService;

    private DispatchService(){
        availableDrivers=new CopyOnWriteArrayList<>();
        executorService= Executors.newScheduledThreadPool(4);
    }
    public static DispatchService getInstance(){
        if(instance==null){
            synchronized (DispatchService.class){
                if(instance==null){
                    instance=new DispatchService();
                }
            }
        }
        return instance;
    }
    public void registerDriver(Driver driver){
        if(!availableDrivers.contains(driver)){
            availableDrivers.add(driver);
        }
    }
    private double computeDistance(Location loc1, Location loc2){
        double dLat=loc1.getLat() - loc2.getLat();
        double dLoc= loc1.getLon()-loc2.getLon();
        return Math.sqrt(dLat * dLat + dLoc*dLoc);
    }
}

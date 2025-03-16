package org.example.OnlineAuction;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuctionScheduler {
    private static AuctionScheduler auctionScheduler=new AuctionScheduler();
    private final ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(4);
    private AuctionScheduler(){
    }
    public static AuctionScheduler getInstance(){
        return auctionScheduler;
    }
    public void shutdown(){
        scheduledExecutorService.shutdown();
    }
    public void scheduleAuctionEnd(Auction auction){
        scheduledExecutorService.schedule(auction::autoEndAuction, auction.getDuration(), TimeUnit.SECONDS);
    }
}

package org.example.OnlineAuction;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineAuction {
    private static volatile OnlineAuction instance;
    private final Map<String, Auction> currentAuctions;
    private final UserManager userManager;
    private final AuctionScheduler auctionScheduler;
    private OnlineAuction(){
        currentAuctions=new ConcurrentHashMap<>();
        userManager=UserManager.getInstance();
        auctionScheduler=AuctionScheduler.getInstance();
    }
    public static OnlineAuction getInstance(){
        if(instance==null){
            synchronized (OnlineAuction.class){
                if(instance==null){
                    instance=new OnlineAuction();
                }
            }
        }
        return instance;
    }
    public User registerUser(String username, String password){
        return userManager.addUser(username, password);
    }
    public boolean login(String username, String password){
        return userManager.authenticate(username,password);
    }
    public void addAuction(Auction auction){
        currentAuctions.putIfAbsent(auction.getAuctionId(), auction);
    }
    public void startAuction(String auctionId){
        Auction auction=currentAuctions.get(auctionId);
        if(Objects.isNull(auction)){
            System.out.println("Invalid auction id");
            return;
        }
        System.out.println("Auction has been started!");
        auctionScheduler.scheduleAuctionEnd(auction);
    }
    public boolean placeBid(Bidder bidder, String auctionId, double price){
        Auction auction=currentAuctions.get(auctionId);
        return auction.placeBid(bidder, price);
    }
}

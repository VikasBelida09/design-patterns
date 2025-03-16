package org.example.OnlineAuction;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Auction {
    private String auctionId;
    private String itemName;
    private String itemDescription;
    private double initialPrice;
    private User seller;

    private double currentBidPrice;
    private User bidder;
    private boolean isActive;

    private Set<Bidder> bidders;
    private int duration;

    private final ReentrantLock lock=new ReentrantLock();
    Auction(String itemName, String itemDescription, double initialPrice, User seller, int duration){
        this.itemDescription=itemDescription;
        this.itemName=itemName;
        this.initialPrice=initialPrice;
        this.seller=seller;
        this.auctionId="AUCTION-"+ UUID.randomUUID().toString().substring(0,8);
        this.duration=duration;
        isActive=true;
        currentBidPrice=0.0d;
        bidders=new HashSet<>();
    }
    public boolean placeBid(Bidder bidder, double price){
        if(!isActive){
            System.out.println("Auction has been ended!");
            return false;
        }
        lock.lock();
        boolean isBidSuccessful=false;
        try{
            if(this.currentBidPrice >= price){
                System.out.println("Your bid price: "+price+" is lesser than the current highest bid: "+ currentBidPrice);
            }else{
                bidders.add(bidder);
                currentBidPrice=price;
                this.bidder=bidder;
                for(Bidder bdr: bidders){
                    if(bdr!=bidder){
                        bdr.receiveNotification("Current Bid price is:"+ currentBidPrice+" by: "+ bidder.getName());
                    }
                }
                isBidSuccessful=true;
            }
        }finally{
            lock.unlock();
        }
        return isBidSuccessful;
    }
    private void endAuction(){
        isActive=false;
        System.out.println("Auction has been ended! with max bid: "+ currentBidPrice+" by bidder: "+ bidder);
    }
    public void autoEndAuction(){
        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(duration);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            endAuction();
        }).start();
    }

    public String getAuctionId() {
        return auctionId;
    }

    public int getDuration() {
        return duration;
    }
}

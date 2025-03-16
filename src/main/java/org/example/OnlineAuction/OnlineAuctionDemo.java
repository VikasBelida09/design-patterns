package org.example.OnlineAuction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnlineAuctionDemo {
    public static void main(String[] args) throws InterruptedException{
        OnlineAuction onlineAuction=OnlineAuction.getInstance();
        Bidder bidder1=new Bidder("vikas","1234");
        Bidder bidder2=new Bidder("vikas-12", "4321");

        User seller=new User("dhoni","23342");
        Auction auction=new Auction("flower pot","ancient flower pot from 1000 B.C",1000.0,seller,20);
        onlineAuction.registerUser(bidder1.getName(), bidder1.getPassword());
        onlineAuction.registerUser(bidder2.getName(), bidder2.getPassword());
        onlineAuction.registerUser(seller.getName(), seller.getPassword());


        onlineAuction.login(bidder1.getName(), bidder1.getPassword());
        onlineAuction.login(bidder2.getName(), bidder2.getPassword());
        onlineAuction.login(seller.getName(), seller.getPassword());

        onlineAuction.addAuction(auction);
        onlineAuction.startAuction(auction.getAuctionId());
        ExecutorService executorService= Executors.newFixedThreadPool(4);

        executorService.submit(()->{
            try{
                Thread.sleep(1000);
                System.out.println("here calling");
                auction.placeBid(bidder1, 1010);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        });
        executorService.submit(()->{
            try{
                Thread.sleep(1500);
                auction.placeBid(bidder2, 1012);
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        });
        executorService.submit(()->{
            try{
                Thread.sleep(2000);
                auction.placeBid(bidder1,1020);
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        });
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }

        // Wait long enough for both auctions to end.
        Thread.sleep(15000);
        AuctionScheduler.getInstance().shutdown();
    }
}

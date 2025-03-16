package org.example.RealTimeStockAggregator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RealTimeStockAggregator {
    private final ConcurrentHashMap<String, TreeMap<Long, TradeEvent>>symbolData;
    private final int slidingWindowSize;
    private RealTimeStockAggregator(int slidingWindowSize){
        this.slidingWindowSize=slidingWindowSize;
        this.symbolData=new ConcurrentHashMap<>();
    }
    public void addTradeEvent(TradeEvent event){
        symbolData.computeIfAbsent(event.getSymbol(),k->new TreeMap<>()).put(event.getTimestamp(), event);

        //clean-up if there are any events which are older ones we shall remove them as we dont need them
        removeOlderEntries(event.getSymbol(), event.getTimestamp());
    }
    private void removeOlderEntries(String stockSymbol, long currentTimeStamp){
        TreeMap<Long, TradeEvent> events=symbolData.get(stockSymbol);
        long cutOffTimeStamp=currentTimeStamp - slidingWindowSize;
        NavigableMap<Long, TradeEvent>olderEntries=events.headMap(cutOffTimeStamp,true);
        Set<Long> olderEntriesKey=new HashSet<>(olderEntries.keySet());
        for(Long key:olderEntriesKey){
            events.remove(key);
        }
    }
    public AggregatedMetrics aggregatedMetrics(String stockSymbol, long currentTimeStamp){
        TreeMap<Long, TradeEvent> events=symbolData.get(stockSymbol);
        if(events==null)return new AggregatedMetrics(0,0.0);

        //remove Older Events with reagards to current timestamp

        removeOlderEntries(stockSymbol,currentTimeStamp);
        long totalVolume=0;
        double totalPrice=0.0;
        for (Map.Entry<Long, TradeEvent> entry : events.entrySet()) {
            TradeEvent event = entry.getValue();
            totalVolume += event.getQty();
            totalPrice+= event.getPrice() * event.getQty();
        }
        totalPrice = totalPrice==0.0?0.0: totalPrice/totalVolume;
        return new AggregatedMetrics(totalVolume, totalPrice);
    }
}

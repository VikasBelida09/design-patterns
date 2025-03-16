package org.example.RealTimeSalesVolumeAggregator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SalesAggregator {
    private final TreeMap<Long, List<SalesEvent>>salesEventsByTimestamps;
    private final ConcurrentHashMap<String, TreeMap<Long, SalesEvent>>salesEvents;
    private final int slidingWindowSize;
    private SalesAggregator(int slidingWindowSize){
        this.slidingWindowSize=slidingWindowSize;
        this.salesEvents=new ConcurrentHashMap<>();
        this.salesEventsByTimestamps=new TreeMap<>();
    }
    public void addSalesEvent(SalesEvent salesEvent){
        salesEvents.computeIfAbsent(salesEvent.getProductSKU(),k->new TreeMap<>());
        salesEvents.get(salesEvent.getProductSKU()).put(salesEvent.getTimestamp(), salesEvent);

        salesEventsByTimestamps.computeIfAbsent(salesEvent.getTimestamp(),k->new ArrayList<>());
        salesEventsByTimestamps.get(salesEvent.getTimestamp()).add(salesEvent);

//        remove older entries
        removeOlderEntriesForSymbol(salesEvent.getProductSKU(), salesEvent.getTimestamp());
        removeOlderEntries(salesEvent.getTimestamp());
    }
    private void removeOlderEntries(long currentTimeStamp){
        long cutOff=currentTimeStamp - slidingWindowSize; // both are in ms
        NavigableMap<Long, List<SalesEvent>> olderEntries= salesEventsByTimestamps.headMap(cutOff, true);

        Set<Long> keysToBeRemoved=new HashSet<>(olderEntries.keySet());
        for(Long key:keysToBeRemoved){
            salesEventsByTimestamps.remove(key);
        }
    }
    private void removeOlderEntriesForSymbol(String symbol, long currentTimestamp){
        if(!salesEvents.containsKey(symbol)) return;
        long cutOff=currentTimestamp - slidingWindowSize; // both are in ms
        TreeMap<Long, SalesEvent>salesEventTreeMap=salesEvents.get(symbol);
        NavigableMap<Long, SalesEvent> olderEntries= salesEventTreeMap.headMap(cutOff, true);

        Set<Long> keysToBeRemoved=new HashSet<>(olderEntries.keySet());
        for(Long key:keysToBeRemoved){
            salesEventTreeMap.remove(key);
        }
    }
    public AggregatedSales getAggregatedSalesForSymbol(String symbol, long currentTimeStamp){
        if(!salesEvents.containsKey(symbol))return new AggregatedSales(0,symbol, 0.0);
        removeOlderEntriesForSymbol(symbol,currentTimeStamp);
        TreeMap<Long, SalesEvent>salesEvent=salesEvents.get(symbol);
        long totalSales=0;
        double avgUnitsSold=0;
        for(Map.Entry<Long, SalesEvent>events: salesEvent.entrySet()){
            totalSales+=events.getValue().getUnitsSold();
        }
        avgUnitsSold = salesEvent.size()==0? 0.0: (double) totalSales /salesEvent.size();
        return new AggregatedSales(totalSales,symbol,avgUnitsSold);
    }
    public List<String> topKSKUSold(long currentTimestamp, int k){
        removeOlderEntries(currentTimestamp);
        NavigableMap<Long, List<SalesEvent>> sales=salesEventsByTimestamps.headMap(currentTimestamp, true);
        Map<String, Long> skuSalesCounter=new HashMap<>();
        for(Map.Entry<Long, List<SalesEvent>>m:sales.entrySet()){
            List<SalesEvent>salesAtThatTime=m.getValue();
            for(SalesEvent s:salesAtThatTime){
                skuSalesCounter.put(s.getProductSKU(),skuSalesCounter.getOrDefault(s.getProductSKU(),0L)+s.getUnitsSold());
            }
        }
        PriorityQueue<Map.Entry<String, Long>>maxHeap=new PriorityQueue<Map.Entry<String, Long>>((a,b)->Long.compare(b.getValue(),a.getValue()));
        List<String>topSKUs=new ArrayList<>();
        for(Map.Entry<String, Long>m:skuSalesCounter.entrySet()){
            maxHeap.offer(m);
        }
        while(!maxHeap.isEmpty() && k-- >0){
            topSKUs.add(maxHeap.poll().getKey());
        }
        return topSKUs;
    }


}

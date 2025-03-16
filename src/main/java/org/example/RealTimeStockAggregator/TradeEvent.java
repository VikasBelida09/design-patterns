package org.example.RealTimeStockAggregator;

public class TradeEvent {
    private String symbol;
    private int qty;
    private double price;
    private long timestamp;

    public TradeEvent(String symbol, int qty, double price, long timestamp) {
        this.symbol = symbol;
        this.qty = qty;
        this.price = price;
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

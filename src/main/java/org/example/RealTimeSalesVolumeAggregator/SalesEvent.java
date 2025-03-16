package org.example.RealTimeSalesVolumeAggregator;

public class SalesEvent {
    private String productSKU;
    private long timestamp;
    private long unitsSold;

    public SalesEvent(String productSKU, long timestamp, long unitsSold) {
        this.productSKU = productSKU;
        this.timestamp = timestamp;
        this.unitsSold = unitsSold;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getUnitsSold() {
        return unitsSold;
    }
}

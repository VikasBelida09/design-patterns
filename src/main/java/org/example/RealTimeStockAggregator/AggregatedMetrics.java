package org.example.RealTimeStockAggregator;

public class AggregatedMetrics {
    long totalVolume;
    double totalPrice;

    public AggregatedMetrics(long totalVolume, double totalPrice) {
        this.totalVolume = totalVolume;
        this.totalPrice = totalPrice;
    }

    public long getTotalVolume() {
        return totalVolume;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "AggregatedMetrics{" +
                "totalVolume=" + totalVolume +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

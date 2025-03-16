package org.example.RealTimeSalesVolumeAggregator;

public class AggregatedSales {
    private long totalSales;
    private String productSku;
    private double averageUnitsSold;

    public AggregatedSales(long totalSales, String productSku, double averageUnitsSold) {
        this.totalSales = totalSales;
        this.productSku = productSku;
        this.averageUnitsSold = averageUnitsSold;
    }

    public long getTotalSales() {
        return totalSales;
    }

    public String getProductSku() {
        return productSku;
    }

    public double getAverageUnitsSold() {
        return averageUnitsSold;
    }
}

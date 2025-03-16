package org.example.RealTimeSocialMediaFeedAggregation;

public class AggregatedPostDetails {
    long totalLikes;
    long totalShares;
    double averageLikes;
    double averageShares;

    public AggregatedPostDetails(long totalLikes, long totalShares, double averageLikes, double averageShares) {
        this.totalLikes = totalLikes;
        this.totalShares = totalShares;
        this.averageLikes = averageLikes;
        this.averageShares = averageShares;
    }

    public long getTotalLikes() {
        return totalLikes;
    }

    public long getTotalShares() {
        return totalShares;
    }

    public double getAverageLikes() {
        return averageLikes;
    }

    public double getAverageShares() {
        return averageShares;
    }

    @Override
    public String toString() {
        return "AggregatedPostDetails{" +
                "totalLikes=" + totalLikes +
                ", totalShares=" + totalShares +
                ", averageLikes=" + averageLikes +
                ", averageShares=" + averageShares +
                '}';
    }
}

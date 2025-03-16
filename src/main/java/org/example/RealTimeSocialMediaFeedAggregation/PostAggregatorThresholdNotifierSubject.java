package org.example.RealTimeSocialMediaFeedAggregation;

public interface PostAggregatorThresholdNotifierSubject {
    void addObserver(PostAggregatorObserver postAggregatorObserver);
    void removeObserver(PostAggregatorObserver postAggregatorObserver);
    void udpdateEveryOne(AggregatedPostDetails aggregatedPostDetails);
}

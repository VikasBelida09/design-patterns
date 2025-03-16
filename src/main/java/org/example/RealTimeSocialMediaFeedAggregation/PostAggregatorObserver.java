package org.example.RealTimeSocialMediaFeedAggregation;

public interface PostAggregatorObserver {
    void receiveNotificaiton(AggregatedPostDetails details);
}

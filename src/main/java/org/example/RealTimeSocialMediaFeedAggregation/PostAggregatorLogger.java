package org.example.RealTimeSocialMediaFeedAggregation;

public class PostAggregatorLogger implements PostAggregatorObserver {
    @Override
    public void receiveNotificaiton(AggregatedPostDetails details) {
        System.out.println("Logging posts: " + details);
    }
}

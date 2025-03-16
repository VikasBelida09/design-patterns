package org.example.RealTimeSocialMediaFeedAggregation;

public class EmailPostFeedNotification implements AggregatedPostFeedNotification{
    @Override
    public void sendNotification(String content) {
        System.out.println("[EMAIL]: "+ content);
    }
}

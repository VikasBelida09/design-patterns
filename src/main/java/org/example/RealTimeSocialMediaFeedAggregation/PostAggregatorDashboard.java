package org.example.RealTimeSocialMediaFeedAggregation;

public class PostAggregatorDashboard implements PostAggregatorObserver{
    @Override
    public void receiveNotificaiton(AggregatedPostDetails details) {
        System.out.println("Dashboard reviewing these posts: "+details);
    }
}

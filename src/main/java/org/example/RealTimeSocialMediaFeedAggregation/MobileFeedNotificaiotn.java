package org.example.RealTimeSocialMediaFeedAggregation;

public class MobileFeedNotificaiotn implements AggregatedPostFeedNotification{

    @Override
    public void sendNotification(String content) {
        System.out.println("[MOBILE]: "+ content);
    }
}

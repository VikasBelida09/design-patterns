package org.example.RealTimeSocialMediaFeedAggregation;

import java.util.List;

public class PostAggregatorNotifcation implements PostAggregatorThresholdNotifierSubject{
    List<PostAggregatorObserver> observers;
    @Override
    public void addObserver(PostAggregatorObserver postAggregatorObserver) {
        observers.add(postAggregatorObserver);
    }

    @Override
    public void removeObserver(PostAggregatorObserver postAggregatorObserver) {
        observers.remove(postAggregatorObserver);
    }

    @Override
    public void udpdateEveryOne(AggregatedPostDetails aggregatedPostDetails) {
        for(PostAggregatorObserver observer:observers){
            observer.receiveNotificaiton(aggregatedPostDetails);
        }
    }
}

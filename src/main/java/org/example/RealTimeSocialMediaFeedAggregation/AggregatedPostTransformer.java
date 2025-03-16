package org.example.RealTimeSocialMediaFeedAggregation;

public abstract class AggregatedPostTransformer {
    protected AggregatedPostFeedNotification aggregatedPostFeedNotification;
    public AggregatedPostTransformer(AggregatedPostFeedNotification aggregatedPostFeedNotification){
        this.aggregatedPostFeedNotification=aggregatedPostFeedNotification;
    }
    public abstract String transform(AggregatedPostDetails aggregatedPostDetails);
    public void send(AggregatedPostDetails aggregatedPostDetails){
        aggregatedPostFeedNotification.sendNotification(this.transform(aggregatedPostDetails));
    }

}

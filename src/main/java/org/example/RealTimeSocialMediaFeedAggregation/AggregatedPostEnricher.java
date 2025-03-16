package org.example.RealTimeSocialMediaFeedAggregation;

public class AggregatedPostEnricher extends AggregatedPostTransformer{
    public AggregatedPostEnricher(AggregatedPostFeedNotification aggregatedPostFeedNotification) {
        super(aggregatedPostFeedNotification);
    }

    @Override
    public String transform(AggregatedPostDetails aggregatedPostDetails) {
        return "Post Enrichment logic"+ aggregatedPostDetails;
    }
}

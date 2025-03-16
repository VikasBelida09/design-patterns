package org.example.RealTimeSocialMediaFeedAggregation;

import java.util.UUID;

public class Comment {
    private String content;
    private String commentId;
    public Comment(String content){
        this.content=content;
        this.commentId="CMT-"+ UUID.randomUUID().toString().substring(0,8);
    }
}

package org.example.Twitter;

import java.util.Date;

public class Tweet {
    private int tweetId;
    private String content;
    private Date timestamp;
    public Tweet next;
    private User author;

    public Tweet(int tweetId,String content, User author){
        this.content=content;
        this.tweetId=tweetId;
        this.timestamp=new Date();
        this.author=author;
    }

    public int getTweetId() {
        return tweetId;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Tweet getNext() {
        return next;
    }

    public User getAuthor() {
        return author;
    }
}

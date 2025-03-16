package org.example.RealTimeSocialMediaFeedAggregation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post {
    private String postId;
    private Author author;
    private String content;
    private long timestamp;
    private long likes;
    private long shares;
    private List<Comment> comments;

    public Post(Author author, String content, long timestamp, long likes, long shares) {
        this.author = author;
        this.content = content;
        this.timestamp = timestamp;
        this.likes = likes;
        this.shares = shares;
        this.postId="POST-"+ UUID.randomUUID().toString().substring(0,8);
        comments=new ArrayList<>();
    }

    public String getPostId() {
        return postId;
    }

    public Author getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getLikes() {
        return likes;
    }

    public long getShares() {
        return shares;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", likes=" + likes +
                ", shares=" + shares +
                '}';
    }
}

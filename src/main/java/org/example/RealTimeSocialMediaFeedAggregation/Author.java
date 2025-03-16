package org.example.RealTimeSocialMediaFeedAggregation;

public class Author {
    private String userName;
    private String authorId;

    public Author(String userName, String authorId) {
        this.userName = userName;
        this.authorId = authorId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAuthorId() {
        return authorId;
    }
}

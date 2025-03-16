package org.example.Twitter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private String name;
    private final String userId;
    private final Set<User> followers;
    private final Set<User> followees;
    private Tweet tweetHead;

    public User(String name){
        this.userId="USR"+ UUID.randomUUID().toString().substring(0,8);
        this.name=name;
        followers=new HashSet<>();
        followees=new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<User> getFollowees() {
        return followees;
    }
    public void addTweet(Tweet tweet){
        tweet.next=tweetHead;
        tweetHead=tweet;
    }

    public Tweet getTweetHead() {
        return tweetHead;
    }
}

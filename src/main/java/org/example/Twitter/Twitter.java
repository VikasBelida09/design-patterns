package org.example.Twitter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Twitter {
    private static volatile Twitter instance;
    private final Map<String, User> userMap;
    private final AtomicInteger counter=new AtomicInteger(0);
    private Twitter(){
        userMap=new ConcurrentHashMap<>();
    }
    public static Twitter getInstance(){
        if(instance==null){
            synchronized (Twitter.class){
                if(instance==null){
                    instance=new Twitter();
                }
            }
        }
        return instance;
    }
    public User addUser(String name){
        if(userMap.containsKey(name)){
            throw new UserNameAlreadyExists(name);
        }
        User user=new User(name);
        userMap.put(user.getName(), user);
        return user;
    }
    public void postTweet(String username, String content){
        User user=userMap.get(username);
        if(Objects.isNull(user))throw new UserNotFoundException(username);
        int tweetId=counter.incrementAndGet();
        Tweet tweet=new Tweet(tweetId,content, user);
        user.addTweet(tweet);
    }
    public void followUser(String followerUserName, String followeeUserName){
        if(!userMap.containsKey(followerUserName)) throw new UserNotFoundException(followerUserName);
        if(!userMap.containsKey(followeeUserName)) throw new UserNotFoundException(followeeUserName);
        User follower=userMap.get(followerUserName);
        User followee=userMap.get(followeeUserName);

        followee.getFollowers().add(follower);
        follower.getFollowees().add(followee);
    }
    public List<Tweet> generateTimelineForUser(String userName, int k){
        if(!userMap.containsKey(userName))throw new UserNotFoundException(userName);

        User user=userMap.get(userName);
        Set<User> followees=user.getFollowees();
        PriorityQueue<Tweet>maxHeap=new PriorityQueue<>((tweet1, tweet2)-> tweet2.getTweetId() - tweet1.getTweetId());

        followees.forEach(u->maxHeap.offer(u.getTweetHead()));
        List<Tweet>tweets=new ArrayList<>();
        while(!maxHeap.isEmpty() && k-- > 0){
            Tweet tweet=maxHeap.poll();
            tweets.add(tweet);
            if(tweet.next!=null)maxHeap.offer(tweet.next);
        }
        return tweets;
    }
}

package org.example.RealTimeSocialMediaFeedAggregation;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SocialMediaPostsAggreagator {
    private final ConcurrentHashMap<String, TreeMap<Long, Post>>authorPosts;
    private final int slidingWindowSize;
    private static volatile SocialMediaPostsAggreagator instance;
    private final SocialMediaPostValidator postValidator;
    private final PostAggregatorNotifcation postAggregatorNotifcation;
    private final long THRESHOLD=100;
    private final AggregatedPostTransformer aggregatedPostTransformer;

    private SocialMediaPostsAggreagator(int slidingWindowSize){
        this.slidingWindowSize=slidingWindowSize;
        authorPosts=new ConcurrentHashMap<>();
        Set<String> set = new HashSet<String>(Arrays.asList("Bad", "Bad1", "bad2"));
        postValidator=new PostContentValidator(set);
        postAggregatorNotifcation=new PostAggregatorNotifcation();
        aggregatedPostTransformer=new AggregatedPostEnricher(new EmailPostFeedNotification());
    }
    public void registerObserver(PostAggregatorObserver postAggregatorObserver){
        this.postAggregatorNotifcation.addObserver(postAggregatorObserver);
    }
    public static SocialMediaPostsAggreagator getInstance(int slidingWindowSize){
        if(instance==null){
            synchronized (SocialMediaPostsAggreagator.class){
                if(instance==null){
                    instance=new SocialMediaPostsAggreagator(slidingWindowSize);
                }
            }
        }
        return instance;
    }
    public void addPost(Post post){
        if(!postValidator.validate(post))return;
        long currentTimestamp=System.currentTimeMillis();
        authorPosts.computeIfAbsent(post.getAuthor().getAuthorId(),k->new TreeMap<>());
        authorPosts.get(post.getAuthor().getAuthorId()).put(currentTimestamp, post);

        removeOlderPostsForAuthor(post.getAuthor().getAuthorId(),currentTimestamp);
    }
    private void removeOlderPostsForAuthor(String authorId,long currentTimeStamp){
        TreeMap<Long, Post>posts=authorPosts.get(authorId);
        long cutOff=currentTimeStamp-slidingWindowSize;
        NavigableMap<Long, Post>olderPosts=posts.headMap(cutOff,true);
        Set<Long>keysToBeRemoved=new HashSet<>(olderPosts.keySet());
        for(Long key:keysToBeRemoved){
            posts.remove(key);
        }
    }
    public void removeOlderPostsForEveryOne(long currentTimestamp){
        for(String authorId: authorPosts.keySet()){
            removeOlderPostsForAuthor(authorId, currentTimestamp);
        }
    }
    public AggregatedPostDetails getAggregatedPostDetails(String authorId, long currentTimestamp){
        if(!authorPosts.containsKey(authorId))return new AggregatedPostDetails(0,0,0.0,0.0);
        removeOlderPostsForAuthor(authorId,currentTimestamp);

        TreeMap<Long, Post>posts=authorPosts.get(authorId);
        long totalLikes=0, totalShares=0;
        for(Map.Entry<Long, Post>post:posts.entrySet()){
            totalShares+=post.getValue().getShares();
            totalLikes+=post.getValue().getLikes();
        }
        double avgLikes=(totalLikes==0 || posts.size()==0) ? 0.0 : (double)totalLikes/posts.size();
        double avgShares=(totalShares==0 || posts.size()==0) ? 0.0 : (double)totalShares/ posts.size();
        AggregatedPostDetails aggregatedPostDetails=new AggregatedPostDetails(totalLikes,totalShares,avgLikes,avgShares);
        if(totalLikes >= THRESHOLD)postAggregatorNotifcation.udpdateEveryOne(aggregatedPostDetails);
        aggregatedPostTransformer.send(aggregatedPostDetails);
        return aggregatedPostDetails;
    }
    public List<Post> topKPostsByEngagement(long currentTimeStamp, int k){
        removeOlderPostsForEveryOne(currentTimeStamp);

        List<Post>posts=authorPosts.values().stream()
                .flatMap(map->map.values().stream())
                .toList();
        PriorityQueue<Post>minHeap=new PriorityQueue<>((post1, post2)->{
             if(post1.getLikes() == post2.getLikes())return Long.compare(post2.getShares(), post1.getShares());
             return Long.compare(post2.getLikes() , post1.getLikes());
        });
        for(Post post:posts){
            minHeap.offer(post);
            if(minHeap.size() > k)minHeap.poll();
        }
        List<Post>postList=new ArrayList<>();
        while(minHeap.isEmpty() && k-- >0){
            postList.add(minHeap.poll());
        }
        Collections.reverse(postList);
        return postList;
    }

}

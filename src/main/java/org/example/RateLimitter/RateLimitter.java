package org.example.RateLimitter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RateLimitter {
    private final ConcurrentMap<String, TokenBucket>map;
    private static volatile RateLimitter instance;
    private final int maxRefills;
    private final long refillPeriod;
    private RateLimitter(int maxRefills, long refillPeriod){
        map=new ConcurrentHashMap<>();
        this.maxRefills=maxRefills;
        this.refillPeriod=refillPeriod;
    }
    public static RateLimitter getInstance(int maxRefills, long refillPeriod){
        if(instance==null){
            synchronized (RateLimitter.class){
                if(instance==null){
                    instance=new RateLimitter(maxRefills, refillPeriod);
                }
            }
        }
        return instance;
    }
    public boolean allowRequest(String userKey){
        map.computeIfAbsent(userKey, k->new TokenBucket(System.currentTimeMillis(),maxRefills));
        TokenBucket tokenBucket=map.get(userKey);
        synchronized (tokenBucket){
            refillTokens(tokenBucket);
            if(tokenBucket.getNumTokens() == 0)return false;
            tokenBucket.setNumTokens(tokenBucket.getNumTokens()-1);
        }
        return true;
    }
    public void refillTokens(TokenBucket tokenBucket){
        long lastRefilledAt= tokenBucket.getLastRefilledTimestamp();
        if(System.currentTimeMillis() - lastRefilledAt < refillPeriod)return ;
        int qty= (int) ((int)(System.currentTimeMillis() -lastRefilledAt)/refillPeriod);
        tokenBucket.setNumTokens(Math.min(tokenBucket.getNumTokens()+qty, maxRefills));
        tokenBucket.setLastRefilledTimestamp(System.currentTimeMillis());
    }
}

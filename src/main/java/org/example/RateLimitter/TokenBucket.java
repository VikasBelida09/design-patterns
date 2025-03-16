package org.example.RateLimitter;

public class TokenBucket {
    private long lastRefilledTimestamp;
    private int numTokens;

    public TokenBucket(long lastRefilledTimestamp, int numTokens) {
        this.lastRefilledTimestamp = lastRefilledTimestamp;
        this.numTokens = numTokens;
    }

    public long getLastRefilledTimestamp() {
        return lastRefilledTimestamp;
    }

    public int getNumTokens() {
        return numTokens;
    }

    public void setLastRefilledTimestamp(long lastRefilledTimestamp) {
        this.lastRefilledTimestamp = lastRefilledTimestamp;
    }

    public void setNumTokens(int numTokens) {
        this.numTokens = numTokens;
    }
}

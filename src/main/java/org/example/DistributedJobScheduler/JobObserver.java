package org.example.DistributedJobScheduler;

public interface JobObserver {
    void onJobComplete(Job job);
    void onJobFailed(Job job, Exception ex);
}

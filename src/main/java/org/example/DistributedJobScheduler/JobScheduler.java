package org.example.DistributedJobScheduler;

public interface JobScheduler {
    void submitJob(Job job);
    void shutdown();
    void registerObserver(JobObserver observer);
    void removeObserver(JobObserver observer);
}

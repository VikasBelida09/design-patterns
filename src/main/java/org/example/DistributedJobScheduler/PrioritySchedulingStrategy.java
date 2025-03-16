package org.example.DistributedJobScheduler;

import java.util.Comparator;

public class PrioritySchedulingStrategy implements SchedulingStrategy{
    @Override
    public Comparator<Job> getComparator() {
        return Comparator.comparingInt(Job::getJobPriority).reversed();
    }
}

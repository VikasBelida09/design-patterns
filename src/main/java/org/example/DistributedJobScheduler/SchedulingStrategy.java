package org.example.DistributedJobScheduler;

import java.util.Comparator;

public interface SchedulingStrategy {
    Comparator<Job> getComparator();
}

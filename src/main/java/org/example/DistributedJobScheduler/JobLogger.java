package org.example.DistributedJobScheduler;

public class JobLogger implements JobObserver{
    @Override
    public void onJobComplete(Job job) {
        System.out.println("Job "+job.getJobId() +" is completed");
    }

    @Override
    public void onJobFailed(Job job, Exception ex) {
        System.out.println("Job "+job.getJobId()+" is failed "+ ex.getMessage());
    }
}

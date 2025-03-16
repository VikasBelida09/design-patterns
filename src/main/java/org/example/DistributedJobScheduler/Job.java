package org.example.DistributedJobScheduler;

import java.util.UUID;

public class Job {
    private String jobId;
    private JobStatus jobStatus;
    private Runnable task;
    private String jobDescription;
    private int jobPriority;

    public Job(Runnable task, String jobDescription, int jobPriority) {
        this.task = task;
        this.jobDescription = jobDescription;
        this.jobPriority = jobPriority;
        this.jobId="JOB-"+ UUID.randomUUID().toString().substring(0,8);
        this.jobStatus=JobStatus.PENDING;
    }

    public String getJobId() {
        return jobId;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public Runnable getTask() {
        return task;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public int getJobPriority() {
        return jobPriority;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
}

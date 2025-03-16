package org.example.DistributedJobScheduler;

import java.util.List;
import java.util.concurrent.*;

public class DistributedJobScheduler implements JobScheduler{
    private final ExecutorService executorService;
    private final BlockingQueue<Job>jobQueue;
    private static volatile DistributedJobScheduler distributedJobScheduler;
    private List<JobObserver>jobObservers;

    private DistributedJobScheduler(SchedulingStrategy schedulingStrategy, int poolSize){
        this.executorService= Executors.newFixedThreadPool(poolSize);
        jobQueue=new PriorityBlockingQueue<>(11, schedulingStrategy.getComparator());
        this.jobObservers=new CopyOnWriteArrayList<>();
        startWorkerThread();
    }
    public static synchronized DistributedJobScheduler getInstance(SchedulingStrategy schedulingStrategy, int poolSize){
        if(distributedJobScheduler==null){
            distributedJobScheduler=new DistributedJobScheduler(schedulingStrategy,poolSize);
        }
        return distributedJobScheduler;
    }
    void startWorkerThread(){
        Runnable worker=()->{
          while(!Thread.currentThread().isInterrupted()){
              try{
                  Job job=this.jobQueue.take();
                  job.setJobStatus(JobStatus.RUNNING);
                  executorService.submit(()->{
                      try{
                          job.getTask().run();
                          job.setJobStatus(JobStatus.COMPLETED);
                            notifyJobCompleted(job);
                      }catch (Exception ex){
                            job.setJobStatus(JobStatus.FAILED);
                            notifyjobFailure(job, ex);
                      }
                  });
              }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
              }
          }
        };
        Thread thread=new Thread(worker, "JobWorker");
        thread.setDaemon(true);
        thread.start();
    }
    @Override
    public void submitJob(Job job) {
        jobQueue.add(job);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    @Override
    public void registerObserver(JobObserver observer) {
        jobObservers.add(observer);
    }

    @Override
    public void removeObserver(JobObserver observer) {
        jobObservers.add(observer);
    }
    public void notifyJobCompleted(Job job){
        for(JobObserver observer:jobObservers){
            observer.onJobComplete(job);
        }
    }
    public void notifyjobFailure(Job job, Exception ex){
        for(JobObserver jobObserver:jobObservers){
            jobObserver.onJobFailed(job, ex);
        }
    }
}

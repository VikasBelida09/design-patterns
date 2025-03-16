package org.example.DistributedJobScheduler;

public class JobSchedulerDemo {
    public static void main(String[] args) throws InterruptedException{
        SchedulingStrategy strategy=new PrioritySchedulingStrategy();
        DistributedJobScheduler distributedJobScheduler=DistributedJobScheduler.getInstance(strategy,3);

        JobObserver logger=new JobLogger();

        distributedJobScheduler.registerObserver(logger);
        Job job=new Job(()->{
            System.out.println("this is job 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "sample job",3);
        Job job2=new Job(()->{
            System.out.println("this is job 2");
            try{
                Thread.sleep(1500);
            }catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }
        },"sample job 2",5);

        distributedJobScheduler.submitJob(job);
        distributedJobScheduler.submitJob(job2);


        Thread.sleep(3000);
        distributedJobScheduler.shutdown();
    }
}

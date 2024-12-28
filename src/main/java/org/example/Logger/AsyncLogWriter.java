package org.example.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class AsyncLogWriter implements LogWriter{
    private final LogWriter logWriter;
    private final BlockingQueue<String> logQueue;
    private final Thread workerThread;
    private volatile boolean running;
    public AsyncLogWriter(LogWriter logWriter){
        this.logWriter=logWriter;
        this.logQueue=new LinkedBlockingDeque<>();
        this.running=true;

        this.workerThread=new Thread(this::processLogQueue);
        this.workerThread.setDaemon(true);
        this.workerThread.start();
    }
    private void processLogQueue(){
        while(running || !logQueue.isEmpty()){
            try{
                String message=logQueue.poll();
                if(message!=null){
                    logWriter.write(message);
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to process log message:"+e.getMessage());
            }
        }
    }
    @Override
    public void write(String message) {
      if(!running){
          throw new IllegalStateException("AsyncLogWriter has been shut down");
      }
      try{
          logQueue.put(message);
      }catch (InterruptedException ex){
          Thread.currentThread().interrupt();
      }
    }
    public void shutdown(){
        running=false;
        try{
            workerThread.join();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    public boolean isQueueEmpty(){
        return this.logQueue.isEmpty();
    }
}

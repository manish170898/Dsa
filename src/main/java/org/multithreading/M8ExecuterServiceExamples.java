package org.multithreading;

import org.lld.old.designPatterns.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


class SingleThreadExecutor implements Runnable{
    private int id;
    SingleThreadExecutor(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Task with ID" + id + "is in work - thread id" + Thread.currentThread().getName());
        long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//Scheduled Executor service
class StockMarkteUpdater implements Runnable{

    @Override
    public void run() {
        System.out.println("Downloding stock market udate from web");
    }
}

public class M8ExecuterServiceExamples {
    public static void main(String[] args) {
        // Single Thread executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++){
            executorService.execute(new SingleThreadExecutor(i));
        }
        executorService.shutdown();


        //Scheduled Executor
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new StockMarkteUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);



//        service.shutdown();
//        try{
//            if(!service.awaitTermination(1000, TimeUnit.MILLISECONDS)){
//                service.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            service.shutdownNow();
//            throw new RuntimeException(e);
//        }
    }
}

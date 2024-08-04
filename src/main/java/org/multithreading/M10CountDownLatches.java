package org.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerLatch implements Runnable{
    CountDownLatch latch;
    int id;
    WorkerLatch(CountDownLatch latch, int id){
        this.latch = latch;
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Worker: " + id + "executing");
        latch.countDown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class M10CountDownLatches {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0; i<5; i++){
            service.submit(new WorkerLatch(latch,i));
        }
        latch.await();
        System.out.println("Completed");
        service.shutdown();
    }
}

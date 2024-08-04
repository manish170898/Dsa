package org.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerBarrier implements Runnable{
    int id;
    CyclicBarrier barrier;
    WorkerBarrier(int id, CyclicBarrier barrier){
        this.id = id;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        System.out.println("Worker : " + id + " executing");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work completed for worker " + id + " Waiting for other threads to complete");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All Other Threads completed. Resuming other work");
    }
}
public class M11CyclicBarrier {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(6, new Runnable() {
            @Override
            public void run() {
                System.out.println("Common Work Done");
            }
        });

        for(int i=0; i<6; i++){
            service.submit(new WorkerBarrier(i, barrier));
        }

        service.shutdown();
    }

}

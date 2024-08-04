package org.multithreading;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

class WorkerPublisher implements  Runnable{
    private BlockingQueue<Integer> queue;
    WorkerPublisher(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        int counter = 0;
        while(true){
            queue.add(counter);
            System.out.println("Putting item into the queue " + counter);
            counter++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class WorkerSubscriber implements  Runnable{
    private BlockingQueue<Integer> queue;
    WorkerSubscriber(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true){
            try {
                int counter = queue.take();
                System.out.println("Taking item from Queue "+ counter);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class M12BlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        WorkerPublisher publisher = new WorkerPublisher(queue);
        WorkerSubscriber subscriber = new WorkerSubscriber(queue);

        new Thread(publisher).start();
        new Thread(subscriber).start();
    }
}

package org.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayWorker implements Delayed{

    private long delay;
    private String message;
    DelayWorker(long delay, String message){
        this.delay = System.currentTimeMillis() + delay;
        this.message = message;
    }
    public long getDelay() {
        return delay;
    }
    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "DelayWorker{" +
                "delay=" + delay +
                ", message='" + message + '\'' +
                '}';
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay- System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(delay < ((DelayWorker)o).getDelay())
            return -1;
        if(delay > ((DelayWorker)o).getDelay())
            return 1;
        return 0;
    }
}
public class M13DelayedQueue {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayWorker> queue = new DelayQueue<>();


        //can be inserted my any number of threads
        queue.put(new DelayWorker(1000, "First"));
        queue.put(new DelayWorker(10000, "Second"));
        queue.put(new DelayWorker(1500, "Third"));

        while (!queue.isEmpty()){
            System.out.println(queue.take());
        }
    }
}

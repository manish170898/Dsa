package org.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker{
    public static final int SIZE = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private static int count = 0;
    private Lock lock = new ReentrantLock();
    //replacement of wait and notify
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce() throws InterruptedException {
        while(true){
            lock.lock();
            try{
                while(queue.size() == SIZE){
                    System.out.println("Queue is Full, producer waitinggg ...");
                    notFull.await();
                }
                queue.add(count);
                System.out.println("Produced " + count);
                count++;
                notEmpty.signal();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true){
            lock.lock();
            try{
                while(queue.isEmpty()){
                    System.out.println("Queue is empty, consumer waitinggg ...");
                    notEmpty.await();
                }
                Integer item = queue.poll();
                System.out.println("Consumed " + item);
                notFull.signal();
            }
            finally {
                lock.unlock();
            }
        }
    }
}
public class M4ProducerConsumerWithLocks {
    static Worker worker = new Worker();
    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

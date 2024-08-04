package org.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class M5DeadLock {

    public static Lock lock1 = new ReentrantLock(true);
    public static Lock lock2 = new ReentrantLock(true);

    public void worker1() throws InterruptedException {
        lock1.lock();
        System.out.println("Worker 1 Lock 1 aquired");
        Thread.sleep(300);
        lock2.lock();
        System.out.println("Worker 1 Lock 2 aquired");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() throws InterruptedException {
        lock2.lock();
        System.out.println("Worker 2 Lock 2 aquired");
        Thread.sleep(300);
        lock1.lock();
        System.out.println("Worker 2 Lock 1 aquired");
        lock1.unlock();
        lock2.unlock();
    }


    public static void main(String[] args) {
        M5DeadLock deadLock = new M5DeadLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.worker1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.worker2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();



    }
}

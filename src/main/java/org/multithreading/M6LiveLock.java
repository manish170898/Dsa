package org.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class M6LiveLock {

    public static Lock lock1 = new ReentrantLock(true);
    public static Lock lock2 = new ReentrantLock(true);

    public void worker1() throws InterruptedException {
        while (true) {
            lock1.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("Worker 1 aquires Lock1");

            System.out.println("Worker 1 tries to aquires Lock2");
            if (lock2.tryLock()) {
                System.out.println("Worker 1 aquires Lock2");
                lock2.unlock();
            } else {
                System.out.println("Worker 1 cannot aquires Lock2");
                continue;
            }
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public void worker2() throws InterruptedException {
        while (true) {
            lock2.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("Worker 2 aquires Lock2");

            System.out.println("Worker 2 tries to aquires Lock1");
            if (lock1.tryLock()) {
                System.out.println("Worker 2 aquires Lock1");
                lock1.unlock();
            } else {
                System.out.println("Worker 2 cannot aquires Lock1");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args) {
        M6LiveLock deadLock = new M6LiveLock();
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

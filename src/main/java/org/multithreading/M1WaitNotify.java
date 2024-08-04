package org.multithreading;


class Process{
    public void consume() throws InterruptedException {
        synchronized (this){
            System.out.println("In Consume");
            wait();
            System.out.println("In Consume Again");
            notify();
        }
    }

    public void produce() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("In Produce");
            notify();
            wait();
            System.out.println("In Produce Again");
        }
    }
}
public class M1WaitNotify {
    public static void main(String[] args) {

        Process process = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        t1.start();
        t2.start();
    }
}

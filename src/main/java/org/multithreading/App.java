package org.multithreading;

class Runner1 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("RUnner1 :" + i);
        }
    }
}

class Runner2 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("RUnner2 :" + i);
        }
    }
}

class DeamonWorker implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Deamon Worker");
        }
    }
}

class NormalWorker implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Normal Worker");
    }
}

public class App {

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Runner1());
//        Thread t2 = new Thread(new Runner2());
//
//        t1.start();
//        t2.start();
        // Tells to wait for above threads before starting to complete below operations
        // otherwise sysout executes befire above threads or during.
//        t1.join();
//        t2.join();
//
//        System.out.println("Executions Complete");
//
//        String name = Thread.currentThread().getName();
//        int priority = Thread.currentThread().getPriority();
//        System.out.println(name);
//        System.out.println(priority);
//
//
//        Thread deamonThread = new Thread(new DeamonWorker());
//        Thread normalThread = new Thread(new NormalWorker());
//        deamonThread.setDaemon(true);
//
//        deamonThread.start();
//        normalThread.start();


        process();
    }

    static int counter = 0;

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void increment1(){
        synchronized (lock1){
            counter++;
        }
    }
    public static void increment2(){
        synchronized (lock2){
            counter++;
        }
    }
    public static void process() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100;i++){
                    increment1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100;i++){
                    increment2();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}

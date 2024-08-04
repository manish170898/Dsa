package org.multithreading;

import java.util.ArrayList;
import java.util.List;

class Processer{
    public final Object object = new Object();
    public static final int UPPER_COUNT = 5;
    public static final int LOWER_COUNT = 0;
    private List<Integer> list = new ArrayList<>();
    public void consumer() throws InterruptedException {
        synchronized (object){
           while (true){
               if(list.size() == LOWER_COUNT){
                   System.out.println("WAITING FOR INSERTING ITEMS");
                   object.wait();
               }
               else{
                   System.out.println(list.get(list.size()-1));
                   list.remove(list.size()-1);
                   object.notify();
               }
               Thread.sleep(500);
           }
        }
    }

    public void producer() throws InterruptedException {
        synchronized (object){
            while (true){
                if(list.size() == UPPER_COUNT){
                    System.out.println("WAITING FOR REMOVING ITEMS");
                    object.wait();
                }
                else{
                    System.out.println("Adding : " + (list.size() +1));
                    list.add(list.size()+1);
                    object.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
public class M2ProducerConsumer {
    public static void main(String[] args) {
        Processer process = new Processer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        t2.start();
        t1.start();
    }
}


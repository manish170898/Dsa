package org.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//singleton
enum Downloader{
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);
    public void donwload(){
        try{
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData(){
        try {
            System.out.println("Downloading data" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Downloaded data" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



public class M7Semaphore {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<12; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.donwload();
                }
            });
        }
        executorService.shutdown();
    }
}

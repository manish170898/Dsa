package org.multithreading;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor implements Callable<String>{
    private Integer id;
    Processor(Integer id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "ID: " + id;
    }
}
public class M9Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for(int i=0; i< 5; i++){
            Future<String> future = service.submit(new Processor(i));
            list.add(future);
        }

        for(Future<String> f : list){
            System.out.println(f.get());
        }
    }
}

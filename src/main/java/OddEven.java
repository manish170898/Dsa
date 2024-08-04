import java.util.Map;

class Worker{
    static int counter = 1;
    public synchronized void printOdd() throws InterruptedException {
        while(counter < 100){
            if(counter %2 == 0){
                wait();
            }
            else{
                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }
    public synchronized void printEven() throws InterruptedException {
        while (counter < 100) {
            if (counter % 2 == 1) {
                wait();
            } else {
                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }
}

public class OddEven {
    public static void main(String[] args) {
        Worker worker = new Worker();


        final Map<Integer, String> map;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
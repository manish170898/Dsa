package org.companySpecific.rubrik;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int i;
    private Semaphore fizz, buzz, fizzbuzz, number;

    public FizzBuzz(int n) {
        this.n = n;
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fizzbuzz = new Semaphore(0);
        number = new Semaphore(1);
        i=0;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i<=n) {
            fizz.acquire();
            if(i<=n) {
                printFizz.run();
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i<=n) {
            buzz.acquire();
            if(i<=n) {
                printBuzz.run();
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i<=n) {
            fizzbuzz.acquire();
            if(i<=n) {
                printFizzBuzz.run();
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i<n) {
            number.acquire();
            ++i;
            if(i%3==0 && i%5==0) {
                fizzbuzz.release();
            }
            else if(i%3==0) {
                fizz.release();
            }

            else if(i%5==0) {
                buzz.release();
            }
            else {
                printNumber.accept(i);
                number.release();
            }
        }
        number.acquire();
        ++i;
        fizzbuzz.release();
        fizz.release();
        buzz.release();
        number.release();
    }
}
class Main {
    public static void main(String[] args) {
        int n = 2;  // The length of the FizzBuzz sequence
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        // Create threads
        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz, "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz, "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(num -> System.out.print(num + ", "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start threads
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        // Wait for all threads to complete
        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}



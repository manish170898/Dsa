package org.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker{
    private Lock lock = new ReentrantLock();
    //replacement of wait and notify
    private Condition condition = lock.newCondition();
}
public class M4ProducerConsumerWithLocks {
    public static void main(String[] args) {

    }
}

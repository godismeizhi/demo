package com.example.demo.producerAndConsumer.count;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count1 {

    public static AtomicInteger i;
    public static Lock lock;
    public static Condition condition;

    public static void main(String[] args) {

        i = new AtomicInteger();
        lock = new ReentrantLock();
        condition = lock.newCondition();

        Thread thread1 = new Thread(() -> run(), "0");
        Thread thread2 = new Thread(() -> run(), "1");

        thread1.start();
        thread2.start();
    }

    public static void run() {

        lock.lock();
        try {
            while (i.get() < 100) {
                if (Thread.currentThread().getName().equals(String.valueOf(i.get() % 2))) {
                    System.out.println(Thread.currentThread().getName() + ":" + i.toString());
                    i.getAndIncrement();
                    condition.signalAll();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

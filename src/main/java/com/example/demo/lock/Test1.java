package com.example.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        Thread thread = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                try {
                    System.out.println("获得锁");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        Thread.sleep(5000);
        System.out.println("中断锁");
        thread.interrupt();
        Thread.sleep(5000);
        lock.unlock();
    }
}

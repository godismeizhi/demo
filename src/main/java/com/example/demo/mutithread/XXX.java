package com.example.demo.mutithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class XXX implements Runnable {

    private Test1 test1;
    private CountDownLatch count;
    private CyclicBarrier cyclicBarrier;
    private Semaphore semaphore;

    public XXX(Test1 test1, CountDownLatch count, CyclicBarrier cyclicBarrier, Semaphore semaphore) {
        this.test1 = test1;
        this.count = count;
        this.cyclicBarrier = cyclicBarrier;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10000; i++) {
            test1.total += 1;
        }
        count.countDown();
        semaphore.release();

        try {
            System.out.println("第 " + Thread.currentThread().getName() + " 個线程已经OK");
            //错误写法死锁
            //  synchronized (test1) {
            cyclicBarrier.await();
            //}

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

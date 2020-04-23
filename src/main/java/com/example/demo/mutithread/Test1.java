package com.example.demo.mutithread;

import java.util.concurrent.*;

public class Test1 {

    int total = 0;

    public static void main(String[] args) {

        final Test1 test1 = new Test1();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("執行最終結果的綫程:" + Thread.currentThread().getName());
            System.out.println("result:" + test1.total);
        });

        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 10; i++) {


            for (int j = 0; j < 2; j++) {
                Thread thread = new Thread(new XXX(test1, countDownLatch, cyclicBarrier, semaphore), "第" + j + "个线程");
                thread.start();
            }

            try {
                countDownLatch.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("第" + i + "次執行后的結果:" + test1.total);
            try {
                try {
                    System.out.println("第 " + Thread.currentThread().getName() + " 個线程已经OK");
                    cyclicBarrier.await(3, TimeUnit.SECONDS);

                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

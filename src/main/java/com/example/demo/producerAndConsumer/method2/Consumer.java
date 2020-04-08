package com.example.demo.producerAndConsumer.method2;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {

    private Queue queue;
    Lock lock;
    Condition producerCondition;
    Condition comsumerCondition;


    Consumer(Queue queue, Lock lock, Condition producerCondition, Condition comsumerCondition) {
        this.queue = queue;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.comsumerCondition = comsumerCondition;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            lock.lock();
            try {
                while (0 == queue.size()) {
                    System.out.println("当前队列沒貨了");
                    comsumerCondition.await();
                }
                Object object = queue.poll();
                producerCondition.signalAll();
                System.out.println("消费:" + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("被中断了C");
                return;
            } finally {
                lock.unlock();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

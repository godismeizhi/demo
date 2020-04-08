package com.example.demo.producerAndConsumer.method2;


import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {

    private Queue queue;
    Lock lock;
    Condition producerCondition;
    Condition comsumerCondition;

    AtomicInteger atomicInteger = new AtomicInteger(0);

    Producer(Queue queue, Lock lock, Condition producerCondition, Condition comsumerCondition) {
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
                while (queue.size() == 2) {
                    try {
                        System.out.println("当前队列满");
                        producerCondition.await();
                    } catch (InterruptedException e) {
                        System.out.println("被中断了P");
                        e.printStackTrace();
                        return;
                    }
                }
                atomicInteger.getAndIncrement();
                queue.offer(atomicInteger.toString());
                comsumerCondition.signalAll();
                System.out.println("生产" + atomicInteger.toString());
            } finally {
                lock.unlock();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("被中断了P2");


    }
}

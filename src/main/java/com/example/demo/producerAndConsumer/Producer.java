package com.example.demo.producerAndConsumer;


import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private Queue queue;

    AtomicInteger atomicInteger = new AtomicInteger(0);

    Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            synchronized (queue) {
                while (queue.size() == 10) {
                    System.out.println("当前队列满");
                    queue.notifyAll();
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("被中断了P");
                        e.printStackTrace();
                        return;
                    }
                }
                atomicInteger.getAndIncrement();
                queue.offer(atomicInteger.toString());
                System.out.println("生产" + atomicInteger.toString());
            }
        }
        System.out.println("被中断了P2");


    }
}

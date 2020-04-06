package com.example.demo.producerAndConsumer;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            synchronized (queue) {
                while (0 == queue.size()) {
                    queue.notifyAll();
                    System.out.println("当前队列沒貨了");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("被中断了C");
                        return;
                    }
                }
                Object object = queue.poll();
                System.out.println("消费:" + object);
            }
        }
        System.out.println("被中断了C2");
    }
}

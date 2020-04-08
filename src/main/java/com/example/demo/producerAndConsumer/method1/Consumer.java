package com.example.demo.producerAndConsumer.method1;

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
                    System.out.println("当前队空");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //System.out.println("被中断了C");
                        return;
                    }
                }

                Object object = queue.poll();
                queue.notifyAll();
                System.out.println("消费:" + object);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("被中断了C2");
    }
}

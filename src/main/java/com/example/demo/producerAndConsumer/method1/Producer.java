package com.example.demo.producerAndConsumer.method1;


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
                while (queue.size() == 2) {
                    System.out.println("当前队列满");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        // System.out.println("被中断了P");
                        e.printStackTrace();
                        return;
                    }
                }
                atomicInteger.getAndIncrement();
                queue.offer(atomicInteger.toString());
                queue.notifyAll();
                System.out.println("生产" + atomicInteger.toString());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("被中断了P2");


    }
}

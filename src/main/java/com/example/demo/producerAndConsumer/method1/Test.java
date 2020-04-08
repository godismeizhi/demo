package com.example.demo.producerAndConsumer.method1;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Queue queue = new LinkedList();

        Thread thread1 = new Thread(new Producer(queue));
        Thread thread2 = new Thread(new Consumer(queue));

        thread1.start();
        thread2.start();
        Thread thread3 = new Thread(new Producer(queue));
        Thread thread4 = new Thread(new Consumer(queue));

        thread3.start();
        thread4.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //thread1.interrupt();
        //thread2.interrupt();

        synchronized (queue) {
            System.out.println("Over");

            Thread.sleep(10000);
        }
    }
}

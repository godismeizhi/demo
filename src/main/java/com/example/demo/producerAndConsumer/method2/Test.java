package com.example.demo.producerAndConsumer.method2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {

        Queue queue = new LinkedList();
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition comsumerCondition = lock.newCondition();

        Thread thread1 = new Thread(new Producer(queue, lock, producerCondition, comsumerCondition));
        Thread thread2 = new Thread(new Consumer(queue, lock, producerCondition, comsumerCondition));

        thread1.start();
        thread2.start();


        synchronized (queue) {
            System.out.println("Over");
        }
    }
}

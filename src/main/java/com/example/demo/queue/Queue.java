package com.example.demo.queue;

import java.util.concurrent.*;

public class Queue {

    public static void main(String[] args) {

        //并发队列
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

        //阻塞队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(8);

        //链表阻塞队列
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        //0长度阻塞队列
        SynchronousQueue synchronousQueue = new SynchronousQueue();

        //先后顺序的队列
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();

        //倒计时的队列
        DelayQueue delayQueue = new DelayQueue();


    }
}

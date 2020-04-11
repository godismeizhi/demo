package com.example.demo.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test2 {

    public static void main(String[] args) {


        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();


    }
}

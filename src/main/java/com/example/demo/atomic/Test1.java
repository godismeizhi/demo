package com.example.demo.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

public class Test1 {

    public static void main(String[] args) {

        //原子类方法更多
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();

        AtomicLongArray atomicLongArray = new AtomicLongArray(8);


        AtomicReference atomicReference = new AtomicReference();

        //效率更高，但是只适合叠加
        LongAdder longAdder = new LongAdder();
    }
}

package com.example.demo.thread_create;

public class Method1 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runable1());
        thread.start();

        Thread.sleep(10000);
        thread.interrupt();
    }

}

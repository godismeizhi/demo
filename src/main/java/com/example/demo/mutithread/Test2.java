package com.example.demo.mutithread;

public class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();

        synchronized (test2) {
            System.out.println("222");

            synchronized (test2) {
                System.out.println("333");
            }
        }
    }
}

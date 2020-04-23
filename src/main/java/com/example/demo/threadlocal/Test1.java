package com.example.demo.threadlocal;

public class Test1 {

    public static void main(String[] args) {


        ThreadLocal<String> threadLocal = new ThreadLocal();
        threadLocal.set("312312");
        new Test1().test1(threadLocal);
    }


    public void test1(ThreadLocal threadLocal) {
        threadLocal.get();
    }


}

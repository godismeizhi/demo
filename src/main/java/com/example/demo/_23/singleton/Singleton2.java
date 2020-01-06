package com.example.demo._23.singleton;

public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {

        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

package com.example.demo;

import java.util.ServiceLoader;

public class SPItest {

    public static void main(String[] args) {

        ServiceLoader<Shoutable> shoutables = ServiceLoader.load(Shoutable.class);

        for (Shoutable shoutable : shoutables) {
            System.out.println(shoutable.shout());
        }
    }
}

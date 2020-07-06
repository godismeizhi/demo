package com.example.demo.recursive.eightqueen;


import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger();
        int n = 8;
        Queen queens[] = new Queen[n];
        for (int i = 0; i < n; i++) {
            queens[0] = new Queen(i, 0);
            backTrace(n, 0, queens, count);
        }

        System.out.println(count.intValue());

    }


    public static void backTrace(int n, int l, Queen queens[], AtomicInteger count) {

        l += 1;

        if (n < 0 || l < 0) {
            return;
        }

        if (l >= n) {
            count.getAndIncrement();
            return;
        }

        for (int i = 0; i < n; i++) {
            Queen queen = new Queen(i, l);

            if (queen.isCorrect(queens)) {
                queens[l] = queen;
                backTrace(n, l, queens, count);
            }
        }
    }
}

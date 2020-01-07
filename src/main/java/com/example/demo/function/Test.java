package com.example.demo.function;

public class Test {

    public static void main(String[] args) {

        Function<Integer, Integer> function = x -> x * 2;
        Function<Integer, Integer> function1 = x -> x + 1;

        Function function3 = function.andThen(function1);
        System.out.println(function3.apply(3));
    }
}

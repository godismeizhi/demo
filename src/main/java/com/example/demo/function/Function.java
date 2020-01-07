package com.example.demo.function;

public interface Function<P, R> {

    R apply(P p);

    default <T> Function<P, T> andThen(Function<R, T> function) {
        return p -> function.apply(apply(p));
    }
}

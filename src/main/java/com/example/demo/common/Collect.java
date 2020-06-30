package com.example.demo.common;

import java.util.Iterator;

public interface Collect<T> extends Iterator<T> {

    void add(T data);

    void remove(T data);
}

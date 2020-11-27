package com.example.demo.dynimic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxy implements InvocationHandler {

    private Subject subject;

    SubjectProxy(Subject subject){
        this.subject =subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("pre hello");
        Object invoke = method.invoke(subject,args);
        System.out.println("after hello");

        return invoke;
    }
}

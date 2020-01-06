package com.example.demo.lambda;


/**
 * Computable 只能是接口，不可以是抽象类
 * Computable 只能有一个方法
 * lambda 只不过是实现接口的对象
 */
public class Test {

    public static void main(String[] args) {

        Test.test((a, b) -> a + b);

        Test.test((a, b) -> a);
    }

    public static void test(Computable computable) {
        System.out.println(computable.computing(3, 2));
    }
}

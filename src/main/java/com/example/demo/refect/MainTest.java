package com.example.demo.refect;


import java.lang.reflect.Constructor;

public class MainTest {

    public static void main(String[] args) throws Exception {


        System.out.println("=================================");
        getClassData();
        System.out.println("=================================");
    }

    public static void getClassData() throws Exception {

        Class<User> clazz = User.class;
        Class<Hello> helloClass = Hello.class;

        Hello hello = clazz.getAnnotation(helloClass);
        System.out.println(hello.value());

        Constructor<User> constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class);
        //constructor.setAccessible(true);
        User user = constructor.newInstance("张三", "2312", "好难啊");
        System.out.println(user.getAaaa());

        Class<SuperClass> superClazz = SuperClass.class;
        Class clazz2 = clazz.getSuperclass();
        if (clazz2 == superClazz) {
            System.out.println("1111");
        }

        Class<?>[] clazzes = clazz.getInterfaces();
        for (Class class1 : clazzes) {
            System.out.println(class1);
        }
    }
}

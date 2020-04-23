package com.example.demo.callable;

import java.util.concurrent.*;

public class Test1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                //return "231232";
                Thread.sleep(10000);
                throw new RuntimeException();
            }
        });
        System.out.println(future.get());
    }
}

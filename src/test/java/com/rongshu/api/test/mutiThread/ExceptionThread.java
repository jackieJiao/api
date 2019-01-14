package com.rongshu.api.test.mutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
*  an uncaught exception.
* */
public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            exec.execute(new ExceptionThread());
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("dont throw");
        }
        System.out.println("finish");
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught exception");
    }
}
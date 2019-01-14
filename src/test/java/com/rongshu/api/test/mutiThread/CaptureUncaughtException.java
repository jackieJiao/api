package com.rongshu.api.test.mutiThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
* exceptions got caught.
* */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }


    /*
    * 以下代码作用：
    * 新建ThreadFactory,作为线程池的参数。
    * 再该工厂类中，为每个线程增加异常处理器 t.setUncaughtExceptionhandler(new MyUncaughtExceptionHandler)
    * 需要新建MyUncaughtExceptionHandler类
    * */

    private static class HandlerThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            System.out.println(this + " creating new Thread");
            Thread t = new Thread(r);
            System.out.println("created " + t);
            t.setUncaughtExceptionHandler(
                    new MyUncaughtExceptionHandler());
            System.out.println(
                    "eh = " + t.getUncaughtExceptionHandler());
            return t;
        }
        /*
        *
        * */
        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("caught exception");
            }
        }
    }

    private static class ExceptionThread2 implements Runnable {
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("run() by " + t);
            System.out.println(
                    "eh = " + t.getUncaughtExceptionHandler());
            throw new RuntimeException();
        }
    }
}

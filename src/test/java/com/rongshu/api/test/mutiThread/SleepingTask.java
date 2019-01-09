package com.rongshu.api.test.mutiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    public void run() {
        System.out.println("run");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run over");
    }
    public static void main(String[] args) {
        Thread t=new Thread(new SleepingTask());
        t.start();
        System.out.println(t.getPriority());
        System.out.println("main over");


    }
}

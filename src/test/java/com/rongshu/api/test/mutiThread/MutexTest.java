package com.rongshu.api.test.mutiThread;

public class MutexTest {

    public  void a() throws InterruptedException {
        synchronized (MutexTest.class) {
            System.out.println("a");
            Thread.sleep(10000);
        }
    }

    public synchronized void b() throws InterruptedException {
        synchronized (MutexTest.class) {
            System.out.println("b");
            Thread.sleep(10000);
        }
    }


    public static void main(String[] args) {
       // MutexTest mutex=new MutexTest();
        new Thread(){
            @Override
            public void run() {
                try {
                    new MutexTest().a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    new MutexTest().b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("main Thread finish");
    }
}

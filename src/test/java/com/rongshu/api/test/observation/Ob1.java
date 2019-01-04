package com.rongshu.api.test.observation;

public class Ob1 implements Observer {

    @Override
    public void observe(String name) {
        System.out.println("ob1"+" "+name);
    }
}

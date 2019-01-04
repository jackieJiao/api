package com.rongshu.api.test.observation;

public class Ob2 implements Observer {

    @Override
    public void observe(String name) {
        System.out.println("ob2"+" "+name);
    }
}

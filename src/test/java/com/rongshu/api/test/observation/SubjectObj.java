package com.rongshu.api.test.observation;


import java.util.ArrayList;
import java.util.List;

//被观察的对象，
//该对象持有所有Observer,有变化时，可以通知每个observer
public class SubjectObj {
    private final List<Observer> observers=new ArrayList<>();

    public void noticeAll(String s){
        for (Observer ob:observers){
            ob.observe(s);
        }
    }

    public void addObserver(Observer o){
        observers.add(o);
    }
}

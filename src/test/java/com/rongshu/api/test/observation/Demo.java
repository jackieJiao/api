package com.rongshu.api.test.observation;

public class Demo {
    public static void main(String[] args) {
        SubjectObj subjectObj=new SubjectObj();
        subjectObj.addObserver(new Ob1());
        subjectObj.addObserver(new Ob2());

        subjectObj.noticeAll("alarm");


        //lambda way

        subjectObj.addObserver(name -> System.out.println("ob3"));
        subjectObj.addObserver(name -> System.out.println("ob4"));
        subjectObj.noticeAll("al");
    }
}

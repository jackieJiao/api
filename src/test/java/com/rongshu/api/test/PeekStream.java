package com.rongshu.api.test;

import java.util.ArrayList;
import java.util.List;

class Person {
    String id;
    String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class PeekStream {


    public static void main(String[] args) {
        Person p1=new Person("1","jiao1");
        Person p2=new Person("2","jiao2");
        Person p3=new Person("3","3jiao");
        List<Person> list=new ArrayList();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        long c=list.stream()
                .peek(p->
                        System.out.println(p.name))
                .filter(p->p.name.startsWith("j")).peek(
                        p-> System.out.println(p.id))
                .map(p->p.id).count();
        System.out.println();
        System.out.println(c);
    }
}

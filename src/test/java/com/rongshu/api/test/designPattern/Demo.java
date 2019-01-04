package com.rongshu.api.test.designPattern;

public class Demo {
    public static void main(String[] args) {
        Macro m=new Macro();
        CommandAccepter accepter = null;

        //old way 需要有一个Open命令对象实现Action接口；
        m.record(new Open(accepter));
        //lambda way
        //不需要新建一个Close 命令实现。
        m.record(()->accepter.close());
    }
}

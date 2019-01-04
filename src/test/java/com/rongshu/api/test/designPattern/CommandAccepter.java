package com.rongshu.api.test.designPattern;

//真正的执行任务的  命令接受者
public interface CommandAccepter {
    public void save();
    public void open();
    public void close();
}

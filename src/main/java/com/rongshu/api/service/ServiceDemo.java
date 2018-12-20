package com.rongshu.api.service;

import com.rongshu.api.mapper.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceDemo {

    @Autowired
    DemoDao demoDao;

    public String testDemo(){
        String rtnAfterDosomething = "我是返回结果";
        //这里是业务代码
        return rtnAfterDosomething;
    }

    public String queryDemo(){
        return demoDao.queryDemo();
    }
}
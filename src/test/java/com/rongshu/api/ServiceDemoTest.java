package com.rongshu.api;

import com.rongshu.api.service.ServiceDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDemoTest {
    @Autowired
    ServiceDemo serviceDemo;
    @Test
    public void testDemo() {
        String rtn = serviceDemo.queryDemo();
        Assert.assertEquals(rtn, "jiao");
    }

}
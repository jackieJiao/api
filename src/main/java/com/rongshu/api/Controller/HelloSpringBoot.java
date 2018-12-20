package com.rongshu.api.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {
    @RequestMapping(path = {"/helloSpringBoot"})
    public String HelloSpring (){
        System.out.println("hello spring boot");
        return "hello spring boot";
    }

    @RequestMapping(path = {"/getP/{id}"})
    public String getParamDemo1 (@PathVariable("id") int userId){
        System.out.println("get param " + userId);
        return "success get param";
    }

    @RequestMapping(path = {"/getP1"})
    public String getParamDemo2 (@RequestParam(value="id",required = false) int id){
        System.out.println("get param " + id);
        return "success get param";
    }
}

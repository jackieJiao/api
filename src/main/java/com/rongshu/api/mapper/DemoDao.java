package com.rongshu.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DemoDao {
    @Select({"select demo_param from  demo "})
    String queryDemo();
}
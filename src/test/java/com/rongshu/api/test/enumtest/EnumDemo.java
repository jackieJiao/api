package com.rongshu.api.test.enumtest;

public class EnumDemo {

    public static void main(String[] args){
        //直接引用
        Day day =Day.MONDAY;
        System.out.println(day.getDeclaringClass());
        System.out.println(day.compareTo(Day.TUESDAY));
        System.out.println(day.ordinal());
    }

}
//定义枚举类型
enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
package com.rongshu.api.test.thinkinginjava;

import com.rongshu.api.test.Enums;

public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>>
    void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++){
            T t1=Enums.random(rsbClass);
            T t2=Enums.random(rsbClass);
            match(t1,t2);
        }
    }
}

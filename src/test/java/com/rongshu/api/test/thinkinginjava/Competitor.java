package com.rongshu.api.test.thinkinginjava;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
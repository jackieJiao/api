package com.rongshu.api.test;

import java.util.stream.IntStream;

public class PrimesTest {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println(countPrimes1(1000000));
//        countPrimes(1000000);
        System.out.println("time:");
        System.out.println(System.currentTimeMillis()-start);
    }

    //lambda 78499\23548
    private static long countPrimes1(int num) {
        return IntStream.range(1,num)
                .parallel()
                .filter(n->isP(n))
                .count();

    }

    //tally:质数数量\耗时----9593\1200///////78499\86722
    private static void countPrimes(int num) {
        int tally=0;
        for(int i=1;i<=num;i++){
            if(isP(i)){
                tally++;
                //System.out.println(i);
            }


        }
        System.out.println("tally:"+tally);
    }

    private static boolean isP(int num) {
        for(int i=2;i<num;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}

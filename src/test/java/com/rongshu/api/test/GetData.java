package com.rongshu.api.test;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;


public class GetData {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {// TODO Auto-generated method stub
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer(); // view buffer

// 存储int的数组
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});

// 绝对位置读写
//System.out.println(ib.get(3));

        System.out.println("*******************************");
        System.out.println(ib.limit());
        System.out.println(ib.position());

        ib.put(3, 1811);
        System.out.println(ib.limit());
        System.out.println(ib.position());
       //ib.flip();
        ib.rewind();
        System.out.println(ib.limit());
        System.out.println(ib.position());
        System.out.println("*******************************");
//ib.rewind();

        while(ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
        }

    }
}

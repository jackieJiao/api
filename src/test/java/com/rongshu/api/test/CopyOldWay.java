package com.rongshu.api.test;

import java.io.*;

public class CopyOldWay {
    public static void main(String[] args) throws IOException {
        long start=System.currentTimeMillis();
       /* String old="C:\\Users\\jiaoz\\Documents\\MyCode\\api\\test\\data.txt";
        String newCopy="C:\\Users\\jiaoz\\Documents\\MyCode\\api\\test\\data_copy.txt";*/
        String old="C:\\迅雷下载\\test.mp4";
        String newCopy="C:\\迅雷下载\\test_copy.mp4";
        BufferedInputStream br=new BufferedInputStream(new FileInputStream(old));
        BufferedOutputStream bw=new BufferedOutputStream(new FileOutputStream(newCopy));
        byte[] bs=new byte[100000];
        int n;
        while((n=br.read(bs))!=-1)
            bw.write(bs,0,n);


        br.close();
        bw.close();
        System.out.println("old");
        System.out.println(System.currentTimeMillis()-start);


    }
}

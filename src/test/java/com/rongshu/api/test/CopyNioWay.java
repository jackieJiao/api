package com.rongshu.api.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyNioWay {
    public static void main(String[] args) throws IOException {
        long start=System.currentTimeMillis();
        String old="C:\\迅雷下载\\test.mp4";
        String newCopy="C:\\迅雷下载\\test_copy.mp4";

        FileChannel oldfc=new FileInputStream(old).getChannel();
        FileChannel newfc=new FileOutputStream(newCopy).getChannel();
        oldfc.transferTo(0,oldfc.size(),newfc);
        oldfc.close();
        newfc.close();
        System.out.println(System.currentTimeMillis()-start);

    }
}

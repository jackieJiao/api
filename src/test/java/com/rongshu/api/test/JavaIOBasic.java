package com.rongshu.api.test;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class JavaIOBasic {
    public static void main(String[] args) throws IOException {

        File file = new File("d:" + File.separator + "hello.txt");
        OutputStream out = new FileOutputStream(file);
        byte[] bytes = "你好".getBytes("utf-8");
        out.write(bytes);
        out.close();

    }
}

package com.rongshu.api.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOUnblockingServerSide {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuff = ByteBuffer.allocate(1024);
            ByteBuffer writeBuff = ByteBuffer.allocate(128);
            writeBuff.put("received".getBytes());
            writeBuff.flip();

            while (true) {
                System.out.println("for");
                int nReady = selector.select();
                System.out.println(nReady);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {
                    System.out.println();
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable()) {
                        System.out.println("isAcceptable");
                        // 创建新的连接，并且把连接注册到selector上，而且，
                        // 声明这个channel只对读操作感兴趣。
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    else if (key.isReadable()) {
                        System.out.println("isReadable");
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuff.clear();
                        socketChannel.read(readBuff);

                        readBuff.flip();
                        System.out.println("received : " + new String(readBuff.array()));
                        key.interestOps(SelectionKey.OP_WRITE);
                    }
                    else if (key.isWritable()) {
                        System.out.println("isWritable");
                        writeBuff.rewind();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuff);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
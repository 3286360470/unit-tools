package com.unit.tools.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelClientTest {

  public static void main(String[] args) throws IOException {
    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.connect(new InetSocketAddress("localhost", 8080));

    // 发送请求
    ByteBuffer buffer = ByteBuffer.wrap("123456789".getBytes());
    socketChannel.write(buffer);

    // 读取响应
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    int num;
    if ((num = socketChannel.read(readBuffer)) > 0) {
      readBuffer.flip();

      byte[] bytes = new byte[num];
      readBuffer.get(bytes);

      String result = new String(bytes, "UTF-8");

      System.out.println("返回值：" + result);
    }
  }

}

package com.unit.tools.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {

  public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
    AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
    // 下面是Future形式的异步IO
    Future<?> future = client.connect(new InetSocketAddress(8080));
    // 阻塞一下，等待连接成功
    future.get();

    Attachment attachment = new Attachment();
    attachment.setSocketChannel(client);
    attachment.setReadMode(false);
    attachment.setBuffer(ByteBuffer.allocate(2048));
    byte[] data = "I am obot!".getBytes();
    attachment.getBuffer().put(data);
    attachment.getBuffer().flip();

    // 异步发送数据到服务端
    client.write(attachment.getBuffer(), attachment, new ClientChannelHandler());

    // 这里等待一下再退出，给出足够的时间处理数据
    Thread.sleep(500);
  }

}

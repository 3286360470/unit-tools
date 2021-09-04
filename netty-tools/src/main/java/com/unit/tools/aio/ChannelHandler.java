package com.unit.tools.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

public class ChannelHandler implements CompletionHandler<Integer, Attachment> {

  @Override
  public void completed(Integer result, Attachment attachment) {
    if (attachment.isReadMode()) {
      // 读取来自客户端的数据
      ByteBuffer buffer = attachment.getBuffer();
      buffer.flip();
      byte[] bytes = new byte[buffer.limit()];
      buffer.get(bytes);
      String msg = new String(buffer.array()).toString().trim();
      System.out.println("收到来自客户端的数据：" + msg);

      // 响应客户端请求，返回数据
      buffer.clear();
      buffer.put("Response from server!".getBytes(Charset.forName("UTF-8")));
      attachment.setReadMode(false);
      buffer.flip();

      // 写数据到客户端也是异步
      attachment.getSocketChannel().write(buffer, attachment, this);
    } else {
      // 到这里，说明往客户端写数据也结束了，有以下两种选择：
      // 1. 继续等待客户端发送新的数据过来
      attachment.setReadMode(true);
      attachment.getBuffer().clear();
      attachment.getSocketChannel().read(attachment.getBuffer(), attachment, this);
      System.out.println("再次收到来自客户端的数据: " + new String(attachment.getBuffer().array()).toString().trim());
      // 2. 既然服务端已经返回数据给客户端，断开这次的连接
//      try {
//        attachment.getSocketChannel().close();
//      } catch (IOException e) {
//        // let it go
//      }
    }

  }

  @Override
  public void failed(Throwable exc, Attachment attachment) {
    System.out.println("连接断开");
  }
}

package com.unit.tools.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

public class ClientChannelHandler implements CompletionHandler<Integer, Attachment> {
  @Override
  public void completed(Integer result, Attachment attachment) {
    ByteBuffer buffer = attachment.getBuffer();
    if (attachment.isReadMode()) {
      // 读取来自服务端的数据
      buffer.flip();
      byte[] bytes = new byte[buffer.limit()];
      buffer.get(bytes);
      String msg = new String(bytes, Charset.forName("UTF-8"));
      System.out.println("收到来自服务端的响应数据: " + msg);

      // 接下来，有以下两种选择：
      // 1. 向服务端发送新的数据
      attachment.setReadMode(false);
      buffer.clear();
      String newMsg = "new message from client.";
      byte[] data = newMsg.getBytes(Charset.forName("UTF-8"));
      buffer.put(data);
      buffer.flip();
      attachment.getSocketChannel().write(buffer, attachment, this);
      // 2. 关闭连接
//      try {
//        attachment.getSocketChannel().close();
//      } catch (IOException e) {
//        // let it go
//      }
    } else {
      // 写操作完成后，会进到这里
      attachment.setReadMode(true);
      buffer.clear();
      attachment.getSocketChannel().read(buffer, attachment, this);
    }
  }

  @Override
  public void failed(Throwable exc, Attachment attachment) {
    System.out.println("服务器无响应");
  }
}

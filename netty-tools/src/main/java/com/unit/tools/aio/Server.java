package com.unit.tools.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 异步IO (AIO/NIO.2)
 * 两种方式：
 *   1. 返回Future实例
 *   2. 回调（本次示例采用的方式）
 */
public class Server {

  public static void main(String[] args) throws IOException {
    // 实例化，并监听端口
    final AsynchronousServerSocketChannel serverSocketChannel =
        AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8080));

    // 自己定义一个Attachment类，用于传递一些信息
    Attachment attachment = new Attachment();
    attachment.setServerSocketChannel(serverSocketChannel);
    serverSocketChannel.accept(attachment, new CompletionHandler<AsynchronousSocketChannel, Attachment>() {
      @Override
      public void completed(AsynchronousSocketChannel asynchronousSocketChannel, Attachment attachment) {
        try {
          SocketAddress clientAddr = asynchronousSocketChannel.getRemoteAddress();
          System.out.println("收到新的连接：" + clientAddr);

          // 收到新的连接后，server应该重新调用accept方法等待新的连接进来
          attachment.getServerSocketChannel().accept(attachment, this);

          Attachment newAttachment = new Attachment();
          newAttachment.setServerSocketChannel(serverSocketChannel);
          newAttachment.setSocketChannel(asynchronousSocketChannel);
          newAttachment.setReadMode(true);
          newAttachment.setBuffer(ByteBuffer.allocate(2048));

          // 异步读取客户端发来的数据：这里可以继续使用匿名实现类，但是我们采用专门定义一个类的方式(ChannelHandler)
          asynchronousSocketChannel.read(newAttachment.getBuffer(), newAttachment, new ChannelHandler());
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }

      @Override
      public void failed(Throwable exc, Attachment attachment) {
        System.out.println("accept failed.");
      }
    });
    // 为了防止min线程退出
    try {
      Thread.currentThread().join();
    } catch (InterruptedException e) {
      // let it go
    }
  }

}

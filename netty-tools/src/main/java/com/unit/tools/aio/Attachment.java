package com.unit.tools.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

public class Attachment {
  
  private AsynchronousServerSocketChannel serverSocketChannel;
  private AsynchronousSocketChannel socketChannel;
  private boolean isReadMode;
  private ByteBuffer buffer;

  public AsynchronousServerSocketChannel getServerSocketChannel() {
    return serverSocketChannel;
  }

  public void setServerSocketChannel(AsynchronousServerSocketChannel serverSocketChannel) {
    this.serverSocketChannel = serverSocketChannel;
  }

  public AsynchronousSocketChannel getSocketChannel() {
    return socketChannel;
  }

  public void setSocketChannel(AsynchronousSocketChannel socketChannel) {
    this.socketChannel = socketChannel;
  }

  public boolean isReadMode() {
    return isReadMode;
  }

  public void setReadMode(boolean readMode) {
    isReadMode = readMode;
  }

  public ByteBuffer getBuffer() {
    return buffer;
  }

  public void setBuffer(ByteBuffer buffer) {
    this.buffer = buffer;
  }
}

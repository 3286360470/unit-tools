package com.unit.tools.jvm.gc;

public class Finalization {
  public static Finalization finalization;

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Finalizing!!!");
    finalization = this;
  }

  public static void main(String[] args) {
    Finalization f = new Finalization();
    System.out.println("First print Finalization: " + f);
    f = null;
    System.gc();
    try { // 等待gc调用finalize()方法完成
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Second print Finalization: " + f);
    System.out.println(f.finalization);
  }

}

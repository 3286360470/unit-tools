package com.unit.tools.thread;

public class ThreadTest {

  public static void attack() {
    System.out.println("Fighting!!!");
    System.out.println("Current Thread(thread): " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    Thread thread = new Thread() {
      @Override
      public void run() {
        attack();
      }
    };
    System.out.println("Current Thread(main): " + Thread.currentThread().getName());
    thread.run();
    thread.start();
  }

}

package com.unit.tools.thread;

public class WaitSleepDemo {

  public static void main(String[] args) throws InterruptedException {
    final Object lock = new Object();
    new Thread() {
      @Override
      public void run() {
        System.out.println("thread A is waiting to get the lock.");
        synchronized (lock) {
          try {
            System.out.println("thread A get lock.");
            Thread.sleep(2000);
            System.out.println("thread A do wait method.");
            lock.wait(1000);
            System.out.println("thread A done.");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();

    //
    Thread.sleep(10);

    new Thread() {
      @Override
      public void run() {
        System.out.println("thread B is waiting get the lock.");
        synchronized (lock) {
          try {
            System.out.println("thread B get lock.");
            System.out.println("thread B is sleeping 10ms.");
            Thread.sleep(10);
            System.out.println("thread B done.");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
  }

}

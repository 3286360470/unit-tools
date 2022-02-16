package com.unit.tools.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable {
//  private static ReentrantLock lock = new ReentrantLock(true);
  private static ReentrantLock lock = new ReentrantLock(false);

  @Override
  public void run() {
    while (true) {
      try {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "get lock.");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }

//      try (lock.lock()) {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }

  public static void main(String[] args) {
    ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
    Thread t1 = new Thread(reentrantLockDemo);
    Thread t2 = new Thread(reentrantLockDemo);
    t1.start();
    t2.start();
  }

}

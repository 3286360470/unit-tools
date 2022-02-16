package com.unit.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger有一个compareAndSet方法，有两个操作数，第一个是期望值，第二个是希望修改成的值。首先初始值是5，
 * 第一次调用compareAndSet方法的时候，将5拷贝回自己的工作空间，然后改成50，写回到主内存中的时候，
 * 它期望主内存中的值是5，而这时确实也是5，所以可以修改成功，主内存中的值也变成了50，输出true。
 * 第二次调用compareAndSet的时候，在自己的工作内存将值修改成100，写回去的时候，希望主内存中的值是5，
 * 但是此时是50，所以set失败，输出false。这就是比较并交换，也即CAS。
 */
public class AtomicIntegerTest {



  public static void main(String[] args) {
//    AtomicInteger atomicInteger = new AtomicInteger(5);
//    System.out.println(atomicInteger.compareAndSet(5, 50));
//    System.out.println(atomicInteger.compareAndSet(51, 100));

    // 获取jdk 的ext扩展程序目录
//    System.out.println(System.getProperty("java.ext.dirs"));
    System.out.println(System.getProperty("java.class.path"));
  }

}

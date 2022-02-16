package com.unit.tools.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

  @Override
  public String call() throws Exception {
    String value = "test";
    System.out.println("Ready to work");
    Thread.sleep(1000);
    System.out.println("task done");

    return value;
  }
}

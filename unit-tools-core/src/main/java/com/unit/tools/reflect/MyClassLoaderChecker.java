package com.unit.tools.reflect;

/**
 * 自定义ClassLoader测试类
 */
public class MyClassLoaderChecker {

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    MyClassLoader myClassLoader = new MyClassLoader("/Users/youshuo/Documents/GitProject/tmp-test/", "myClassLoader");
    Class<?> testClass = myClassLoader.loadClass("YouShuo");
    System.out.println(testClass.getClassLoader());
    testClass.newInstance();
  }

}

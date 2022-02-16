package com.unit.tools.reflect;

import java.io.*;

/**
 * 自定义ClassLoader
 */
public class MyClassLoader extends ClassLoader {

  private String path;
  private String name;

  MyClassLoader(String path, String name) {
    this.path = path;
    this.name = name;
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    byte[] bytes = loadClassData(name);
    return defineClass(bytes, 0, bytes.length);
  }

  private byte[] loadClassData(String name) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try (InputStream in = new FileInputStream(new File(path + name + ".class"))) {
      int i = 0;
      while ((i = in.read()) != -1) {
        out.write(i);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return out.toByteArray();
  }


}

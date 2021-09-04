package com.unit.tools;

import org.apache.commons.lang3.StringUtils;

public class StringTest {

  public static void main(String[] args) {
    String[] strArrays = StringUtils.split("/home//other", "/");
    System.out.println(strArrays.length);
    for (String str : strArrays) {
      System.out.println(str);
    }
  }

}

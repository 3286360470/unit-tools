package com.unit.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HashMapTest {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    Queue<String> queue = new LinkedList<>();
    for (char c : new char[] {'a', 'b', 'c', 'd', 'c', 'a', 'a', 'd', 'a', 'a'}) {
      String key = String.valueOf(c);
      Integer integer = map.compute(key, (k, v) -> {
        if (v == null) {
          queue.add(key);
          return 1;
        } else {
          return v + 1;
        }
      });
//      System.out.println(integer);
    }

    while (!queue.isEmpty()) {
      String head = queue.poll();
      if (map.get(head) == 1) {
        System.out.println(head);
        return;
      }
    }

    System.out.println("#");
  }

}

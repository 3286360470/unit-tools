package com.unit.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest266 {

  public static int countVowelSubstrings(String word) {
    int count = 0, res = 0;
    char[] chars = word.toCharArray();
    Map<Character, Integer> cache = new HashMap<Character, Integer>() {{
      put('a', 0);
      put('e', 0);
      put('i', 0);
      put('o', 0);
      put('u', 0);
    }};
    for (int i = 0; i <= chars.length - 5; ++i) {
      for (int j = i; j < chars.length; ++j) {
        char c = chars[j];
        if (count >= 5) {
          ++res;
        }
        if (cache.keySet().contains(c)) {
          // is vowel
          Integer appearCount = cache.get(c);
          if (appearCount > 0) {
            // has appeared
            cache.put(c, appearCount + 1);
          } else {
            // has not appeared, count it
            cache.put(c, 1);
            ++count;
          }
        } else {
          count = 0;
          for (Map.Entry<Character, Integer> entry : cache.entrySet()) {
            entry.setValue(0);
          }
          break;
        }
      }
    }

    return res;
  }

  public static int countVowelSubstrings2(String word) {
    int countVowel = 0, res = 0;
    int[] asic = new int[128];
    char[] chars = word.toCharArray();
    for (int i = 0; i <= chars.length - 5; ++i) {
      for (int j = i; j < chars.length; ++j) {
        char cur = chars[j];
        if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
          if (asic[cur] == 0) {
            asic[cur] = 1;
            ++countVowel;
          } else {
            asic[cur]++;
          }
        } else {
          break;
        }
        if (countVowel >= 5) {
          ++res;
        }
      }
      asic['a'] = asic['e'] = asic['i'] = asic['o'] = asic['u'] = 0;
      countVowel = 0;
    }
    return res;
  }

  public static long countVowels(String word) {
    long res = 0;
    int[] asic = new int[128];
    List<String> subString = new ArrayList<>();
    for (int i = 0; i < word.length(); ++i) {
      for (int j = word.length() - 1; j >= i; --j) {
        subString.add(word.substring(i, j + 1));
      }
    }
    for (String s : subString) {
      for (char cur : s.toCharArray()) {
        if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
          if (asic[cur] == 0) {
            asic[cur] = 1;
          } else {
            asic[cur]++;
          }
        }
      }
    }
    res = asic['a'] + asic['e'] + asic['i'] + asic['o'] + asic['u'];

    return res;
  }

  public static long countVowels2(String word) {
    long res = 0;
    int[] asic = new int[128];
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      for (int j = chars.length - 1; j >= i; --j) {
        for (int k = i; k <= j; ++k) {
          char cur = chars[k];
          if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
            if (asic[cur] == 0) {
              asic[cur] = 1;
            } else {
              asic[cur]++;
            }
          }
        }

      }
    }
    res = asic['a'] + asic['e'] + asic['i'] + asic['o'] + asic['u'];

    return res;
  }

  public static long countVowels3(String word) {
    long res = 0, last = 0;
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      for (int j = i; j < chars.length; ++j) {
        char cur = chars[j];
        if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
          last += 1;
          res += last;
        } else {
          res += last;
        }
      }
      last = 0;
    }

    return res;
  }

  public static long countVowels4(String word) {
    long res = 0;
    for (int i = 0; i < word.length(); ++i) {
      char cur = word.charAt(i);
      if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
        res += i + i * (word.length() - i - 1) + word.length() - i - 1;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(countVowelSubstrings2("cuaieuouac"));
    System.out.println(countVowels("aba"));
  }

}

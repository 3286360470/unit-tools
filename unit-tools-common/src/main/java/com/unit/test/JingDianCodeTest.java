package com.unit.test;

import java.util.*;
import java.util.stream.Collectors;

public class JingDianCodeTest {

  public static void main(String[] args) {
//    System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
//    System.out.println(longestPalindrome("bb"));
//    System.out.println(restoreIpAddresses("25525522135"));
//    Scanner in = new Scanner(System.in);
//    List<Integer> list = new ArrayList();
//    System.out.println("请输入字符串");
//
//    for (String s : in.nextLine().split(" ")) {
//      list.add(Integer.valueOf(s));
//    }
//    int count = in.nextInt();
//    System.out.println(Arrays.toString(list.toArray()));
//    System.out.println(count);
//
//    Map<Long, Set<Long>> map = new HashMap();
//    map.compute(2l, (k, v) -> {
//      if (v == null) {
//        Set<Long> temp = new HashSet();
//        temp.add(1l);
//        return temp;
//      } else {
//        v.add(3l);
//        return v;
//      }
//    });
//    long round = Math.round(Math.pow(10, 0) * (2 - 1));
//    System.out.println(romanToInt("DCXXI"));
//    System.out.println(longestCommonPrefix(new String[] {"abca","abc","abca","abc","abcc"}));
//    System.out.println(isValid("({}{}[()]}{)"));
//    System.out.println(getDistance(new String[] {"lab","lab","nhb","nhb","lab","nhb","nhb","nhb","lab"}, 9, "nhb","lab"));
//    System.out.println(sortStrings(new String[] {"ab","ba","abc","cba"}, 4));
//    System.out.println(sortStrings(new String[] {"emmaldzsvjggzfoda","skmjhsm","zjwmkgufsvwrwyvrhk","vyksgrwwjmwrhzfvuk","wfszrykvjrmuwhkvgw","kwrwuwjvksyvhmrzfg","kom","mko","mko","nezrxmdjgjqexmqz","gjmqdrzqzjeemxxn","qqxedgjjmrznmxez","xxgmjezerjnqmzdq","vwcmmngdsvzx","xvmdvwscgnmz","msnvvczxdgwm","izmvzrhltsiubcukc","cslnzuenr","rznulsenc","lnsnucrez","gkyfvvni","gikvvynf","ivkfyvng","vygfvikn","nwxkeyhnvniquhpapw","wnhyknvanhepwquxip","rrpujexoukmmrnmpdzcf","ksirghrnjx","ixrhgkrnjs","kup","kpu","kpu","emnetqjwnfwi","qpozvklf","qpvkolfz","flpkvoqz","zlkpvfoq","zldjqciktnevrkb","vklqjdrktcebizn","ntrqkvebiljczkd","nkktcebjirqvldz","mytegbucud","gbtcyuemud","gctmuedybu","ahgeomesgcehvk","oamshhecevggek","gmcekevoehsahg","gvgeacmheeoksh","ma","am","am","wxdyddyrenzsylfwx","syedwdylxrwfyxzdn","dwsddyelxywrxyfnz","rdrrfuowxukryfmli","qdjzmdobajs","ymysuotfxpboc","awzccscrkozbhygrkvv","ovrgybhswrczzkcacvk","zcrwkyhrzkgacvsocbv","vzwgzosrkvkcrcybahc","ftytv","ttvyf","tfyvt","vtytf","pggunxuyduy","qijygauutkt","aytqutkugji","itjutqugaky","nfoenumvnmannkkhmueo","ounmkhknefvemnmannou","eonmenfkhmuaonnnumvk","mvnouemekonfamnnnhku","a"}, 74));
    System.out.println(chkParenthesis("()(()()", 10));

  }

  public static boolean chkParenthesis(String A, int n) {
    // write code here
    Stack<Character> stack = new Stack();
    char[] arr = A.toCharArray();
    for (Character ch : arr) {
      if (ch == '(') stack.push(')');
      else if (ch == '{') stack.push('}');
      else if (ch == '[') stack.push(']');
      else if (stack.size() > 0 && ch == stack.pop()) continue;
      else return false;

    }

    return stack.size() == 0;
  }

  public static ArrayList<String> sortStrings(String[] str, int n) {
    ArrayList<String> res = new ArrayList();
    Map<String, String> map = new HashMap();
    for (int i = 0; i < n; ++i) {
      char[] arr = str[i].toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      String value = map.get(key);
      if (value == null || value.compareTo(str[i]) > 0) {
        map.put(key, str[i]);
      }
    }
    res.addAll(map.values());
    Collections.sort(res);
    return res;
  }

  public static ArrayList<String> sortStrings1(String[] str, int n) {
    // write code here
    Set<String> res = new TreeSet();
    Map<String, String> cache = new HashMap();
    for (String subStr : str) {
      String sortStr = sortInternal1(subStr);
      cache.compute(sortStr, (k, v) -> {
        if (v == null) {
          res.add(subStr);
          return subStr;
        } else if (subStr.compareTo(v) < 0) {
          res.remove(v);
          res.add(subStr);
          return subStr;
        } else {
          return v;
        }
      });
    }

    return new ArrayList(res);
  }

  private static String sortInternal1(String subStr) {
    char[] arr = subStr.toCharArray();
    StringBuilder sb = new StringBuilder();
    int len = subStr.length();
    for (int i = 0; i < len; ++i) {
      for (int j = 1; j < len - i; ++j) {
        if (arr[j - 1] > arr[j]) {
          char temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    for (Character ch : arr) {
      sb.append(String.valueOf(ch));
    }

    return sb.toString();
  }

  public static int getDistance(String[] article, int n, String x, String y) {
    // write code here
    int xAddr = -1, yAddr = -1, min = n;
    for (int i = 0; i < n; ++i) {
      if (x.equals(article[i])) {
        if (yAddr > 0) {
          int abs = Math.abs(i - yAddr);
          min = abs < min ? abs : min;
        }

        xAddr = i;
      } else if (y.equals(article[i])) {
        if (xAddr > 0) {
          int abs = Math.abs(i - xAddr);
          min = abs < min ? abs : min;
        }

        yAddr = i;
      }
    }

    return min;
  }

  public static boolean isValid (String s) {
    // write code here
    int len = s.length();
    if (len % 2 != 0) return false;
    Stack<Character> stack = new Stack();
    char[] chArr = s.toCharArray();

    for (Character c : chArr) {
      if (stack.size() == 0 ||
          (stack.peek().equals('(') && !c.equals(')')) ||
          (stack.peek().equals('{') && !c.equals('}')) ||
          (stack.peek().equals('[') && !c.equals(']'))) {
        stack.push(c);
      } else if (stack.size() != 0 && (
          (stack.peek().equals('(') && c.equals(')')) ||
              (stack.peek().equals('{') && c.equals('}')) ||
              (stack.peek().equals('[') && c.equals(']')))) {
        stack.pop();
      }
      String test = "slssl";


    }
    if (stack.size() == 0) return true;
    else return false;
  }

  public static String longestCommonPrefix (String[] strs) {
    // write code here
    Stack<String> stack = new Stack();
    int arrSize = strs.length;
    int stackSize = 0;
    while(true) {
      if (strs[0].length() <= stackSize) {
        return String.join("", new ArrayList(stack));
      }
      String pivot = String.valueOf(strs[0].charAt(stackSize));
      for (int i = 1; i < arrSize; ++i) {
        String str = strs[i];
        if (str.length() <= stackSize || (str.length() > stackSize && !String.valueOf(str.charAt(stackSize)).equals(pivot))) {
          return String.join("", new ArrayList(stack));
        }
      }
      ++stackSize;
      stack.push(pivot);
    }

  }

  public static int romanToInt (String s) {
    // write code here
    int len = s.length();
    int res = 0;
    if (len == 0) {
      return res;
    }
    String[][] value1 = {
        {"","I","II","III","IV","V","VI","VII","VIII","IX"},
        {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        {"","M","MM","MMM"}
    };
    Map<String, Integer> value = new HashMap();
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 10; ++j) {
        value.put(value1[i][j], Double.valueOf(Math.pow(10, i) * (j)).intValue());
      }
    }
    Queue<String> queue = new LinkedList();

    for (int i = 0; i < len; ++i) {
      queue.add(String.valueOf(s.charAt(i)));
    }
    while(!queue.isEmpty()) {
      StringBuilder temp = new StringBuilder();
      while(!queue.isEmpty() && value.get(temp.append(queue.peek()).toString()) != null) {
        queue.poll();
      }
      if (!queue.isEmpty()) {
        temp.deleteCharAt(temp.length() - 1);
      }
      res += value.get(temp.toString());
    }

    return res;
  }



  /**
   *    0  r  a  b  b  b  i  t
   * 0  1  1  1  1  1  1  1  1
   * r  0  1  1  1  1  1  1  1
   * a  0  0  1  1  1  1  1  1
   * b  0  0  0  1  2  3  3  3
   * b  0  0  0  0  1  3  3  3
   * i  0  0  0  0  0  0  3  3
   * t  0  0  0  0  0  0  0  3
   * @param S string字符串
   * @param T string字符串
   * @return int整型
   */
  public int numDistinct(String S, String T) {
    // write code here
    int m = T.length(), n = S.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= n; ++i) {
      // 空字符串是任意字符串的 子序列
      dp[0][i] = 1;
    }
    for (int i = 1; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        dp[i][j] = T.charAt(i - 1) == S.charAt(j - 1) ? dp[i][j - 1] + dp[i - 1][j - 1] : dp[i][j - 1];
      }
    }

    return dp[m][n];
  }

  static final int count = 4;

  public static ArrayList<String> restoreIpAddresses (String s) {
    // write code here
    ArrayList<String> res = new ArrayList();
    Stack<String> stack = new Stack();
    restoreIpAddressInternal(s, 0, stack, res);
    return res;

  }

  private static void restoreIpAddressInternal(String s, int level, Stack<String> stack, ArrayList<String> res) {
    int segSize = stack.size();
    if (segSize == count && level == s.length()) {
      StringBuilder sb = new StringBuilder();
      List<String> temp = new ArrayList(stack);
      sb.append(temp.get(0)).append(".")
          .append(temp.get(1)).append(".")
          .append(temp.get(2)).append(".")
          .append(temp.get(3));
      res.add(new String(sb));
      return;
    }
    if (s.length() - level > 3 * (4 - segSize)) { // 长度大于12或剩余的每小段剩余字符大于3
      return;
    }
    if (s.length() - level < 4 - segSize) { // 剩余字符不够每个段分的：每个段至少一个
      return;
    }
    int num = 0;
    for (int i = level; i < level + 3 && i < s.length(); i++) {
      num = num * 10 + (s.charAt(i) - '0'); //ip每一段的值
      if (num < 0 || num > 255) {
        break;
      }
      stack.push(s.substring(level, i + 1));
      restoreIpAddressInternal(s, i + 1, stack, res);
      stack.pop();
      if (num == 0) {
        break; // 不允许前缀为0
      }
    }

  }

  public static String longestPalindrome(String s) {
    // write code here
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int max = 0;
    String sb = "";
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      max = sb.length();
      sb = centralExtension(s, i, i, len, dp, sb, max);
      sb = centralExtension(s, i, i + 1, len, dp, sb, max);
    }
    return sb;
  }

  public static String centralExtension(String s, int left, int right, int len, boolean[][] dp, String sb, int max) {
    while (left > -1 && right < len && s.charAt(left) == s.charAt(right)) {
      dp[left][right] = true;
      if (max < right - left + 1) {
        sb = s.substring(left, right + 1);
        max = right - left + 1;
      }
      --left;
      ++right;
    }
    return sb;
  }

  public static int lengthOfLongestSubstring(String s) {
    // write code here
    int max = 0;
    int len = s.length();
    if (len == 0) {
      return max;
    }

    boolean[][] dp = new boolean[len][len];
    return lengthOfLongestSubstringInternal(s, max, len);

  }

  public static int lengthOfLongestSubstringInternal(String s, int max, int len) {
    for (int i = 0; i < len; i++) {
      Set<String> temp = new HashSet();
      for (int j = i; j < len; j++) {
        String cur = String.valueOf(s.charAt(j));
        if (temp.contains(cur)) {
          max = Math.max(max, temp.size());
          break;
        }
        temp.add(cur);
      }
    }

    return max;
  }


}

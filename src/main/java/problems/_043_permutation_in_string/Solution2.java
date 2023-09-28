package problems._043_permutation_in_string;

import java.util.HashMap;
import java.util.Map;


public class Solution2 {
  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> maps1 = new HashMap<>();
    int n1 = s1.length();
    int n2 = s2.length();

    if (n1 > n2) {
      return false;
    }

    for (int i = 0; i < n1; ++i) {
      maps1.put(s1.charAt(i), maps1.getOrDefault(s1.charAt(i), 0) + 1);
    }

    for (int i = 0; i <= n2 - n1; ++i) {
      Map<Character, Integer> maps2 = new HashMap<>();
      for (int j = 0; j < n1; ++j) {
        maps2.put(s2.charAt(i + j), maps2.getOrDefault(s2.charAt(i + j), 0) + 1);
      }
      if (maps1.equals(maps2)) {
        return true;
      }
    }
    return false;
  }
}

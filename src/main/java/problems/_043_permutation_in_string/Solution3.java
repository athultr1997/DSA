package problems._043_permutation_in_string;

import java.util.Arrays;


public class Solution3 {
  public boolean checkInclusion(String s1, String s2) {
    int MAX_ARRAY_SIZE = 26;
    int[] maps1 = new int[MAX_ARRAY_SIZE];
    int n1 = s1.length();
    int n2 = s2.length();

    if (n1 > n2) {
      return false;
    }

    for (int i = 0; i < n1; ++i) {
      maps1[s1.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i <= n2 - n1; ++i) {
      int[] maps2 = new int[MAX_ARRAY_SIZE];
      for (int j = 0; j < n1; ++j) {
        maps2[s2.charAt(i + j) - 'a'] += 1;
      }
      if (Arrays.equals(maps1, maps2)) {
        return true;
      }
    }
    return false;
  }
}

package problems._032_palindrome_partitioning_2;

public class Solution1 {

  public int minCut(String s) {
    boolean[][] palindrome = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); ++i) {
      for (int j = 0; j <= i; ++j) {
        if (s.charAt(j) == s.charAt(i) && (i - j < 2 || palindrome[j + 1][i - 1])) {
          palindrome[j][i] = true;
        }
      }
    }
    return minCutHelper(s, palindrome, 0);
  }

  private int minCutHelper(String s, boolean[][] palindrome, int start) {
    if (start == s.length() || palindrome[start][s.length() - 1]) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int end = start; end < s.length(); ++end) {
      if (palindrome[start][end]) {
        min = Math.min(min, 1 + minCutHelper(s, palindrome, end + 1));
      }
    }
    return min;
  }

}

package problems._032_palindrome_partitioning_2;

public class Solution3 {

  public int minCut(String s) {
    int n = s.length();
    int[] dp = new int[n];
    dp[0] = 0;
    boolean[][] palindrome = new boolean[n][n];
    for (int i = 0; i < n; ++i) {
      int min = i;
      for (int j = 0; j <= i; ++j) {
        if (s.charAt(j) == s.charAt(i) && (i - j < 2 || palindrome[j + 1][i - 1])) {
          palindrome[j][i] = true;
          min = j == 0 ? 0 : Math.min(min, 1 + dp[j - 1]);
        }
      }
      dp[i] = min;
    }
    return dp[n - 1];
  }

}

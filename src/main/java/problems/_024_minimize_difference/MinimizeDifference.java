package problems._024_minimize_difference;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MinimizeDifference {

  // Solution I: DFS Brute Force

  public int minimizeTheDifference(int[][] mat, int target) {
    int n = mat.length;
    int m = mat[0].length;
    return dfs(mat, target, 0, 0, n, m);
  }

  private int dfs(int[][] mat, int target, int sum, int i, int n, int m) {
    if (i == n) {
      return Math.abs(sum - target);
    }
    int res = Integer.MAX_VALUE;
    for (int j = 0; j < m; ++j) {
      int cur = dfs(mat, target, sum + mat[i][j], i + 1, n, m);
      res = Math.min(res, cur);
    }
    return res;
  }

  // Solution II: DP Memoization with Optimizations

  public int minimizeTheDifferenceMemoization(int[][] mat, int target) {
    int n = mat.length;
    Integer[][] dp = new Integer[70][5000];
    List<TreeSet<Integer>> matrix = new ArrayList<>(n);
    for (int[] row : mat) {
      TreeSet<Integer> s = new TreeSet<>();
      for (int e : row) {
        s.add(e);
      }
      matrix.add(s);
    }
    return dfs(matrix, target, 0, 0, n, dp);
  }

  private int dfs(List<TreeSet<Integer>> matrix, int target, int sum, int i, int n,
      Integer[][] dp) {
    if (i == n) {
      return Math.abs(sum - target);
    }
    if (dp[i][sum] != null) {
      return dp[i][sum];
    }
    int res = Integer.MAX_VALUE;
    TreeSet<Integer> row = matrix.get(i);
    for (int e : row) {
      int diff = dfs(matrix, target, sum + e, i + 1, n, dp);
      res = Math.min(diff, res);
      if (diff == 0 || res < diff) {
        break;
      }
    }
    dp[i][sum] = res;
    return dp[i][sum];
  }

}

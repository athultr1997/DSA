package problems._71_coin_change_2;

public class SolutionI {

  public int change(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[amount + 1][n];

    for (int j = 0; j < n; ++j) {
      dp[0][j] = 1;
      for (int i = 1; i <= amount; ++i) {
        if (j - 1 >= 0) {
          dp[i][j] += dp[i][j - 1];
        }
        if (i - coins[j] >= 0) {
          dp[i][j] += dp[i - coins[j]][j];
        }
      }
    }

    return dp[amount][n - 1];
  }

}

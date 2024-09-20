package problems._065_0_1_knapsack;

public class SolutionI {

  public int knapSack(int W, int wt[], int val[], int n) {
    int[][] dp = new int[n + 1][W + 1];
    int cand1;
    int cand2;

    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= W; ++j) {
        if (j - wt[i - 1] >= 0) {
          cand1 = val[i - 1] + dp[i - 1][j - wt[i - 1]];
        } else {
          cand1 = 0;
        }
        cand2 = dp[i - 1][j];
        dp[i][j] = Math.max(cand1, cand2);
      }
    }
    return dp[n][W];
  }

}

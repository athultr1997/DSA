package algo._065_0_1_knapsack;

public class SolutionII {

  public int knapSack(int W, int wt[], int val[], int n) {
    int[] dp = new int[W + 1];
    int cand1;
    int cand2;

    for (int i = 0; i <= W; ++i) {
      dp[i] = 0;
    }

    for (int i = 1; i <= n; ++i) {
      // start iteration from the right
      for (int j = W; j >= 1; --j) {
        if (j - wt[i - 1] >= 0) {
          cand1 = val[i - 1] + dp[j - wt[i - 1]];
        } else {
          cand1 = 0;
        }
        cand2 = dp[j];
        dp[j] = Math.max(cand1, cand2);
      }
    }
    return dp[W];
  }

}

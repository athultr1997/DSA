package problems._71_coin_change_2;

public class SolutionII {

  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];

    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; ++i) {
        dp[i] += dp[i - coin];
      }
    }

    return dp[amount];
  }

}

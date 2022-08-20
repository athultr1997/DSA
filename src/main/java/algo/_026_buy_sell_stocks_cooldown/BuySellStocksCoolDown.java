package algo._026_buy_sell_stocks_cooldown;

public class BuySellStocksCoolDown {

  public int maxProfitWithHighSpaceComplexity(int[] prices) {
    int n = prices.length;
    if (n == 1) {
      return 0;
    }
    int[] sell = new int[n];
    int[] buy = new int[n];
    sell[0] = 0;
    buy[0] = -prices[0];
    sell[1] = Math.max(buy[0] + prices[1], sell[0]);
    buy[1] = Math.max(-prices[1], buy[0]);
    for (int i = 2; i < n; ++i) {
      sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
      buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
    }
    return sell[n - 1];
  }

  public int maxProfit(int[] prices) {
    int n = prices.length;
    int s0 = 0;
    int s1 = 0;
    int s2;
    int b0 = -prices[0];
    int b1;
    for (int i = 1; i < n; ++i) {
      s2 = s1;
      s1 = s0;
      b1 = b0;
      s0 = Math.max(b1 + prices[i], s1);
      b0 = Math.max(s2 - prices[i], b1);
    }
    return s0;
  }


}

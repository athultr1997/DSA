package problems._025_buy_and_sell_stock_2;

public class BuyAndSellStock2 {

  public int maxProfitGreedy(int[] prices) {
    int left = 0;
    int right = 1;
    int n = prices.length;
    int maxProfit = 0;
    while (right < n) {
      if (prices[left] < prices[right]) {
        while (right + 1 < n && prices[right] < prices[right + 1]) {
          right++;
        }
        maxProfit += prices[right] - prices[left];
      }
      left = right;
      right++;
    }
    return maxProfit;
  }

  public int maxProfitDP(int[] prices) {
    int prvSold, curSold = 0, prvBought, curBought = -prices[0];
    for (int price : prices) {
      prvSold = curSold;
      prvBought = curBought;
      curSold = Math.max(prvBought + price, prvSold);
      curBought = Math.max(prvSold - price, prvBought);
    }
    return curSold;
  }

}

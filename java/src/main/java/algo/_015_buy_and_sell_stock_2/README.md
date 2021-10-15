# Best Time to Buy and Sell Stock II

Problem Description: [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the
stock at any time. However, you can buy it then immediately sell it on the same day. Find and return
the maximum profit you can achieve.

# Solution 1: Two Pointer Approach (Greedy Approach)

Maintain two pointers left and right. Increment right till all the elements in between left and
right are in increasing order. When an element that is less than the previous element is
encountered, add the difference between the prices at left and right to the total profit. Also,
reset left to right and right to its next element.

**TC - O(N)**

**SC - O(1)**

# Solution 2: Using DP

There are two states in this problem: `Bought` and `Sold`. The state transition equations can de
defined as:

* `bought[i] = max(bought[i - 1], sold[i - 1] - price[i])`
    * Gives the maximum profit when the ith state is `Bought`.
    * I can either keep holding the share I bought or buy the share with the previous best sold
      profit.
* `sold[i] = max(sold[i - 1], bought[i - 1] + price[i])`
    * Gives the maximum profit when the ith state is `Sold`.
    * I can either refrain from buying the share or sell the share with the previous best bought
      profit.

The base cases:

* `bought[0] = - price[0]`: The share can be bought at the first available price.
* `sold[0] = - inf`: The share cannot be sold at first.

Observations:

* `bought[i] <= sold[i]`: We can always make more money by selling as the last step. This is why in
  the end only `curSold` is returned instead of taking maximum of `curSold` and `curBought`.

Since only the previous states are being used, only two variables are required. This will reduce the
space complexity.

**TC - O(N)**

**SC - O(1)**

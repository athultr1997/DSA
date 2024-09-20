# Best Time to Buy and Sell Stock with Cooldown

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e.,
buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day). Note: You
may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
again).

Problem
Link: [309. Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

## Solution 1: Using DP

There are three states in the problem - `buy`, `sell`, `rest`. The states can be defined as follows:

* `buy[i]`: The maximum profit that can be achieved till i with at least the state in `i-1`
  being `buy`.
* `sell[i]`: The maximum profit that can be achieved till i with at least the state in `i-1`
  being `sell`.
* `rest[i]`: The maximum profit that can be achieved till i with at least the state in `i-1`
  being `rest`.

`price[i]` denotes the price of the stock on the _ith_ day. The state transition equations can be
defined as follows:

* `buy[i] = max(rest[i - 1] - price[i], buy[i - 1])`
    * `rest[i - 1] - price[i]` means the last state was cooling down and hence can buy now.
    * `buy[i - 1]` means the current state is in `rest` and the state before that was a `buy`. It
      denotes the cool down phase after a purchase.
    * `sell[i - 1] - price[i]` is not present in the equation due to the constraint in the problem
      that there should be a cool down of one day.

* `sell[i] = max(buy[i - 1] + price[i], sell[i - 1])`
    * `buy[i - 1] + price[i]` means the last state was a `buy`, and the current state was a `sell`.
    * `sell[i - 1]` means that the last state was a `sell` and the current state was a `rest`.

* `rest[i] = max(rest[i - 1], sell[i - 1], buy[i - 1])`
    * The current state is `rest` whatever the `i-1`th state may be.

Observations:

* `buy[i] <= rest[i] <= sell[i]`: buying and doing nothing in the last state will produce less
  profit than selling in the last state.
* The sequence `buy`, `rest`, `buy` is not valid since one cannot buy without selling the stock.
  Also, since buying in the last state is always less than doing nothing in the last
  state, `buy[i] <= rest[i]`. Then the state transition equation for `rest[i]` is modified
  to: `rest[i] = max(rest[i - 1], sell[i - 1]`

* Since selling in the last state will always be greater than cooling down in the last
  state, `rest[i] <= sell[i]`. Then the state transition equation for `rest[i]` can be further
  modified to: `rest[i] = sell[i - 1]`.

* We can substitute the above equation for `rest[i]` in the other two state transition equations.

After optimisations, the state transition equations are reduced to:

* `buy[i] = max(sell[i - 2] - price[i], buy[i - 1])`
* `sell[i] = max(buy[i - 1] + price[i], sell[i - 1])`

Since only the last two states are required, four variables will suffice, and there is no need of
arrays. This reduces the space complexity to _O(1)_.

Base cases:

* We can buy the stock at i = 0, but we cannot sell it at i = 0. Therefore, `buy[0] = -prices[0]`
  and `sell[0] = 0`.

**TC - O(N)**

**SC - O(1)**

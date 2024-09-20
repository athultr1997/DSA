# Coin Change II

Problem
Description: [Coin Change II](https://leetcode.com/problems/coin-change-ii)

## Solution I: Dynamic Programming

### Intuition

* Recursive Relation: `f(amount, i) = f(amount - coins[i], i) + f(amount, i - 1)`, where `i` is the
  index from the start of the coins array.
    * `f(amount - coins[i], i)` represents selecting the same coin again since we can select a coin
      infinite times.
    * `f(amount, i - 1)` represents not selecting the coin at index `i` again.
* When looping the coin loop should be outer. This is because we need to calculate the combinations
  instead of the permutations.
    * When looping coins first, we are always appending a new coin type (or not) to previous
      combination of coins(for a smaller target number), since previous combination is always
      unique, appending a new type of coins will make the combination still unique. We are always
      considering the different coin type in next loop.
    * When looping amount first, the following scenario could happen: If we want to get amount of 8,
      we can append 3 and append 5, also we can append 5 and append 3 to achieve it. In this way, we
      use the two coin(3 and 5) in different way, but the same number (one for each). We will keep
      considering the previous type of coin when the amount is increasing.

### Complexity

Let `N` be the amount.
Let `M` be the number of coins.

#### Time Complexity: O(N.M)

#### Space Complexity: O(N.M)

## Solution II: Space Optimized Dynamic Programming

### Intuition

* The recursive relation depends on elements in the same row and one element in the previous row.
    * The element in the previous row can be considered stored in the same location in the last
      iteration.
* The state variables of the solution do not change. Instead, the representation is compressed.
    * This is because the recursive relation and the brute-force recursive solution cannot function
      with just one variable.
* The observation that options with infinite are not part of state variables remains true here too.
    * Both the state variables chosen here are not part of it. Namely, the index of the coin array
      and the number. The infinite element of selecting each coin any times remains detached from
      the state variables.

### Complexity

Let `N` be the amount.
Let `M` be the number of coins.

#### Time Complexity: O(N.M)

#### Space Complexity: O(N)

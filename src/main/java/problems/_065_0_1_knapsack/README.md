# 0-1 Knapsack Problem

Problem
Description: [0-1 Knapsack Problem](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)

## Solution I: Using Bottom-Up Dynamic Programming

### Recurrence Relation

`K(i,j) = max(P[i] + K(i - 1, j - W[i]), K(i - 1,j))`

where `i` is the first `i` items in the array, and `j` is the weight limit.

### Considerations

* The `W` should be in limits for creating an array.
* There should be zero row and column.
* The mapping from dp cell to weight and profit array must be done carefully. For example, by
  subtracting 1.

### Complexity Analysis

#### Computational Complexity: O(N.W)

#### Space Complexity: O(N.W)

## Solution II: Using Bottom-Up Dynamic Programming With Space Optimization

### Explanation

* Only last row is required for computing the next row.
* The computation should start from the right since the profit for lesser number of items will be
  over-written if we start from left. If we start from right the profit for lesser number of items
  will still be present.

### Complexity Analysis

#### Computational Complexity: O(N.W)

#### Space Complexity: O(W)

## Solution III: Using Greedy Method

### What if all the ratios are the same?

* In this case the method won't work, since it won't know which combination of weight to choose to
  fit
  the capacity the best.
* In the corollary, it won't also work in cases where the profit and the weight are the same.

#### Computational Complexity: O(N.lnN)

#### Space Complexity: O(N)

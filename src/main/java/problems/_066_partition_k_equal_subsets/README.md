# Partition to K Equal Sum Subsets

Problem
Description: [Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets)

## Wrong Solution I: Using 0-1 Knapsack Algorithm

### Algorithm

1. Create a counter map of the numbers in the array.
2. Find if solution for sum / k using 0-1 space-optimized knapsack.
3. Reduce the selected elements from the counter map.
4. Repeat steps 2 to 3 k times.
5. Check if the counter is empty. If empty the partition is possible.

### Why this algorithm won't work

* This is a greedy algorithm.
* This won't work for the same reason greedy algorithm won't work for 0-1 knapsack problem. We might
  choose unoptimized solution early on and reach a state where no solution is possible. However,
  with retry a solution could have been reached.

## Possible Solution I: Using Dynamic Programming

### Recurrence Relation

`K(i,[j1xk1, j2xk2, ...]) = K(i-1, [j1xk1, j2xk2, ...,jfx(kf-1),...])`

`i` is the elements in the array from left. `jxk` is the counter map.

## Solution I: Using backtracking starting from each number

TODO

### Complexity Analysis

#### Computational Complexity: O(N.k^N)

#### Space Complexity: O(N)

## Solution II: Using backtracking starting from each subset

TODO

### Complexity Analysis

#### Computational Complexity: O(N.k^N)

#### Space Complexity: O(N)

## Solution III: Using Dynamic Programming with Bitmask

### Recurrence Relation

`dp[mask | (1 << j)] = (dp[mask] + nums[j]) % target`
where mask represents the current subset, `(1 << j)` represents the element being selected, `num[j]`
is the element being selected.

### Algorithm

1. Find the sum of the elements in `nums`.
2. Return false if `sum` is not divisible by `k`.
3. Find the `targetSum = sum / k`.
4. Let `totalSubsets = (1 << n)` where `n` is the length of `nums`.
5. Create an array `dp` of size `totalSubsets` to store the sum of each subset possible.
6. Mark all elements in `dp` as `-1`. This represents none of the subset are valid in the beginning.
7. Set `dp[0] = 0` before the iteration. When no elements are selected the sum will be zero. This is
   the base condition.
8. For each possible subset, try to select each element in the array `nums`.
    1. Do not select if the subset till now is invalid, i.e., `dp[mask]` is `-1`.
    2. Do not select if the element has already been selected.
    3. Do not select if by selecting the element the sum crosses `targetSum`.
9. Check if the mask representing the selection of all elements is zero or not. If zero the
   partitioning is possible.

### Questions

#### Why is the check `dp[mask] == -1` needed?

It is needed to check if the current mask is valid or not. Only if its valid can the next selections
be made. In some cases it won't be valid. For example if the sum of selected elements are higher
than the target.

#### How is the detection of `k` partitions done? There is no explicit counter for `k`.

Whenever the sum becomes `targetSum` it will be reset to zero. Hence, in the end we only have to
check if the mask representing the selection of all elements is zero or not.

### Complexity Analysis

#### Computational Complexity: O(N.2^N)

#### Space Complexity: O(2^N)

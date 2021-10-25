# Minimize the Difference Between Target and Chosen Elements

Problem
Description: [1981. Minimize the Difference Between Target and Chosen Elements](https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/)

You are given an m x n integer matrix mat, and an integer target. Choose one integer from each row
in the matrix such that the absolute difference between a target, and the sum of the chosen elements
is minimized. Return the minimum absolute difference. The absolute difference between two numbers a
and b is the absolute value of a - b.

## Solution I: Brute Force using DFS

Perform a DFS throughout the entire matrix starting from (0,0) and keep track of the minimum
difference encountered.

**TC-O(m^n)**: One element from each row can be chosen in `m` ways and there are `n` rows.

**SC-O(n)**: The height of the recursion stack which will be `n` in the worst case.

## Solution II: DP with Memoization

Save the results in an array `dp[size of rows][maxiumum sum possible]`. The maximum sum possible is
low in this question hence this approach is possible.

Optimizations:

* Sort each row: In Java, TreeSet can be used for sorting as well as removing duplicates.
* Remove duplicates: using a set
* Break when the difference is zero. The absolute difference cannot be less than zero in any case.
* Break when the difference is greater than the one encountered so far. This is because the row is
  sorted and hence we cannot find lesser difference once it starts increasing.

**TC-O(m^n)**: Sometimes the elements might be such that the sum might not repeat on the same level.

**SC-O(n)**: The height of the recursion stack which will be `n` in the worst case.

## Solution III: Using 4SumII Approach
TODO

## Solution IV: Using All Sums with Bitwise Operations
TODO

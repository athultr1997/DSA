# String Compression

Problem
Description: [String Compression](https://leetcode.com/problems/string-compression/)

## Solution I: Two Pointers

### Explanation

The slow pointer points to the final array being created, while the fast pointer reads the input.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(1)**

## Solution I: Two Pointers

### Explanation

Same as Solution I. Instead of a single loop two loops are used. Also, the issue of starting count from 1 is resolved by
starting count from 0 and checking the starting element twice.

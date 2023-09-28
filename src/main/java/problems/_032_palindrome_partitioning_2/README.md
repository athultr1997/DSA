# Palindrome Partitioning II

Problem
Description: [Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)

Given a string s, partition s such that every substring of the partition is a palindrome. Return the
minimum cuts needed for a palindrome partitioning of s.

N is the number of characters in the string

## Solution I: Brute Force Recursion

Recurrence Relation:

```
minCuts(s, i, j) = 0 if s[i:j] is a palindrome
minCuts(s, i, j) = min{1 + minCuts(s, k + 1, j) : where s[i:k] is a palindrome} when s[i:j] is not a palindrome 
```

Compute all the palindromes beforehand since calculating palindromes and minimum cuts cannot happen
together in this approach.

### Complexity Analysis

**Time Complexity-O(2^N)**: The worst case happens when all the substrings are palindromes. For
example, s = "aaaa".

**Space Complexity-O(N^2)**: Due to the dynamic programming table for storing palindromes.

## Solution II: Dynamic Programming Memoization

TODO

**Time Complexity-O(N^2)**: The worst case happens when the memoization table of size N x N is full.

**Space Complexity-O(N^2)**: Due to the dynamic programming table for storing palindromes.

## Solution III: Dynamic Programming Tabulation

### Complexity Analysis

**Time Complexity-O(N^2)**:

**Space Complexity-O(N^2)**: Due to the dynamic programming table for storing palindromes.

## Solution IV: Based on Manacher's Algorithm

TODO

### Complexity Analysis

**Time Complexity-O(N^2)**:

**Space Complexity-O(N)**:

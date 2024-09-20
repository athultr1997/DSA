# Palindrome Partitioning

Problem
Description: [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

Given a string s, partition s such that every substring of the partition is a palindrome. Return all
possible palindrome partitioning of s. A palindrome string is a string that reads the same backward
as forward.

## Solution I: Using Backtracking

### Algorithm

1. Iteratively generate all possible substrings beginning at start index.
1. The end index increments from start till the end of the string.
1. For each of the substring generated, check if it is a palindrome.
1. If the substring is a palindrome, the substring is a potential candidate. Add the substring to
   the currentList and perform a depth-first search on the remaining substring. If current substring
   ends at index end, end+1 becomes the start index for the next recursive call.
1. Backtrack if start index is greater than or equal to the string length and add the currentList to
   the result.

### Complexity Analysis

N is the length of the string

**Time Complexity-O(N\*(2^N))** There could be O(2^N) possible substrings in the worst case. For
each substring, it takes O(N) time to generate the substring and determine if it is a palindrome or
not. In the Worst case, all the possible substrings are palindrome.

**Space Complexity-O(N)** Due to the depth of the recursion stack in the worst case.

## Solution II: Backtracking with Dynamic Programming

This approach uses a similar Backtracking algorithm as discussed in Approach 1. The previous
approach performs one extra iteration to determine if a given substring is a palindrome or not.
Here, we are repeatedly iterating over the same substring multiple times, and the result is always
the same. These are Overlapping Subproblems, and we could further optimize the approach by using
dynamic programming to determine if a string is a palindrome in constant time.

### Algorithm

A given string ss starting at index `start` and ending at index `end` is a palindrome if following
conditions are satisfied :

1. The characters at start and end indexes are equal.
1. The substring starting at index `start + 1` and ending at index `end−1` is a palindrome.

Use a 2D array of size `NxN` to store whether the substring starting at `start` and ending at `end`
is a palindrome or not. Substitute this logic in the function `isPalindrome`:

```
dp[start][end] = true if s[start:end] is a palindrome
dp[start][end] = true if start == end (all single character strings are palindromes)
dp[start][end] = true if start - end = 1 and s[start] == s[end] (Ex: "aa")
dp[start][end] = true if start - end = 2 and s[start] == s[end] (Ex: "aba")
dp[start][end] = false else
```

Due to the incremental nature of the approach, the palindrome will also be checked in its increasing
order of elements. Therefore, there is no need of null checks in the palindrome dp array. Therefore,
there is no need for a separate isPalindrome function like in the last approach. The function
overhead can be reduced with a simple if condition.

### Complexity Analysis

N is the length of the string

**Time Complexity-O(N\*(2^N))** Same as approach I. However, we are eliminating one additional
iteration to check if substring is a palindrome or not.

**Space Complexity-O(N\*N)** The depth of the recursion stack in the worst case will have O(N). The
dp array will have O(N*N).


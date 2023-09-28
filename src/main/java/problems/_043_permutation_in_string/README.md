# Permutation In String

Problem Description: [Permutation In String](https://leetcode.com/problems/permutation-in-string/)

## Solution I: Brute Force

### Explanation

The universe of possible characters are only 256. So, create a boolean array with 256 characters. Mark true whenever an
element is found.

### Algorithm

1. Generate all permutations of the smaller string s2.
2. Check if each permutation of s2 is present in the bigger string s1.

### Complexity Analysis

#### Computational Complexity

**O(N2! x N1)**

#### Space Complexity

**O(N2! x N2)**: !Need to Verify

### Solution II: HashMap

### Algorithm

1. Iterate through the smaller string s1 and keep the frequencies of characters in a Hash Map.
2. Iterate through the larger string s2 for the length of s1 and keep the frequencies of characters in another Hash Map.
3. Check if the two Hash Maps are equal.
    1. If they are equal return true and terminate.
    2. Else repeat steps 2 to 3 for the next substring of length s1 in s2.

This algorithm can be optimized by:

* If size of s1 is greater, then terminate by returning false.

### Complexity Analysis

#### Computational Complexity

**O(N1 + N1x(N2 - N1))**

#### Space Complexity

**O(1)**: At max 26 characters.

### Solution III: HashMap of Array

Use an array of size 26 as the Hash Table instead of HashMap. Complexity and algorithm remains same as before. But
runtime will decrease since there is no resizing of arrays happening.

### Solution IV: HashMap of Array + Sliding Window

Same as Solution III, but instead of creating a hash table every time when iterating through s2, we can use the same
hash table and increment and decrement the counts of the characters based on the sliding window. Time Complexity is same
as Solution III.

### Solution V: Optimized Sliding Window

Same as Solution IV, but instead of comparing equality of Hash Tables, a count of the equal elements are maintained.
This count is incremented and decremented based on the window sliding. Time Complexity is same
as Solution IV.

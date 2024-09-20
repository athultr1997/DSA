# Reverse Words In a String

Problem
Description: [Reverse Words In a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)

## Solution I: Two-Pointer Approach

### Explanation

1. Rotate the entire string.
2. Rotate each word of the string.
    1. Slow moving pointer denotes the start of the word.
    2. Fast moving pointer denotes the end of the word.
    3. Use above function for rotating each word.
3. Clean the spaces.
    1. Use two-pointer approach.
    2. Slow moving pointer for where the new elements will be inserted.
    3. Fast moving pointer for picking the new elements to be inserted.

### Complexity Analysis

#### Computational Complexity: O(N)

N is the length of the string.

#### Space Complexity: O(1)

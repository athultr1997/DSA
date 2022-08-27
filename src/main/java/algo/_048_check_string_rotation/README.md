# Check If Rotated Strings

Problem
Description: [Check If Rotated Strings](https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/)

## Solution I: Concatenate and Substring

### Explanation

When the rotated string is concatenated twice, the original string will be a substring of this concatenation. Use
inbuilt substring method for implementation.

### Complexity Analysis

#### Computational Complexity

**O(N^2)**

#### Space Complexity

**O(N)**

## Solution II: Two Queues

### Explanation

Add each string to separate queues. Keep popping element from one queue and inserting it in the end of the queue until
both the queues are equal.

### Complexity Analysis

#### Computational Complexity

**O(N^2)**

#### Space Complexity

**O(N)**

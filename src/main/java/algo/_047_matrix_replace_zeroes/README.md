# Matrix Replace Zeroes

Problem
Description: [Matrix Replace Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

## Solution I: Hash Table

### Explanation

Iterate through the matrix and add the rows and column numbers where zeroes where found in separate hash tables. Iterate
through the two hash tables and set the corresponding rows and columns to zeroes.

We are doing two iterations because setting the elements to zero while iterating can increase the complexity because the
replaced zeroes can be confused with original zeroes causing the entire matrix to be zero in the end.

### Complexity Analysis

#### Computational Complexity

**O(N + M)**

#### Space Complexity

**O(N + M)**

## Solution II: Store the zero markings in the matrix itself

### Explanation

Instead of using a separate hash table, we can use the matrix itself to store which columns and rows should be marked as
zeroes. An edge case appears for th first row and column which points to the first element. In this case either the case
that the first row should be empty or the case that the first column should be empty can be stored in a separate boolean
variable. Also, the index column and row should not be replaced with zeroes midway because this can cause the entire
matrix to be zeroes. So, the index column and row are checked and replaced at the end. Using examples is very effective
for this problem to visualize edge cases.

### Complexity Analysis

#### Computational Complexity

**O(N + M)**

#### Space Complexity

**O(1)**

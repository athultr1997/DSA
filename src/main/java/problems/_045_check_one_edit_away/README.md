# Check If One Edit Away

Problem
Description: [Check If One Edit Away](https://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/)

# Solution I: Traversing Two Strings Parallelly

### Explanation

Check the current element in and the next element in both string to determine the operation and increment the pointers
accordingly.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(1)**

## Solution II: Traversing Two Strings Parallelly Optimized

### Explanation

Instead of checking the next element equality, compare the total length of the strings to determine the kind of edit
that will be performed and then increment the pointers accordingly.



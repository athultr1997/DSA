# Remove Duplicates From Sorted Array

Problem
Description: [Remove Duplicates From Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Solution I: Two Pointer Approach

### Algorithm

1. Point one pointer to the start of the array.
2. Point the other pointer to the second element of the array.
3. Check if the last element and the current element pointed by the second pointer are the same.
    1. If they are the same, increment the position of the pointer.
    2. If they are not the same, copy the element to the location of the first pointer and increment the first and the
       second pointer.
4. Repeat step 3 till end of the array is reached.

### Complexity Analysis

#### Computational Complexity

**O(N)**: Worst case happens when input is like: [0,0,1,1,2,2].

#### Space Complexity

**O(1)**: No extra space is being allocated. Everything is done in-place.

## Solution II: Two Pointer Optimized

Same as solution I, except loop is converted to for loop and variables are minimized.

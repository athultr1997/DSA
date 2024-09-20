# Rotate Array

Problem Description: [Rotate Array](https://leetcode.com/problems/rotate-array/)

Given an array, rotate the array to the right by `k` steps, where `k` is non-negative.

Example:

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

## Solution I: Using Additional Array

Copy the array into a new array and then rotate the original array by picking elements from the
copied array. This will prevent the elements getting overridden while rotating.

### Complexity Analysis

**Time Complexity-O(N)**

**Space Complexity-O(N)**

## Solution II: Rotate One by One

The rotation of the array is divided into cycles. When a cycle is completed, it again starts at the
next starting point.

### Algorithm

1. Initialize `start`, `current` `countRotated` to 0.
2. Replace `current` with the element at the rotated position.
3. Store the element being replaced in `temp`.
4. Increment `countRotated` by one.
5. Repeat steps 2 to 4 till the end of array is reached.
6. Increment `start` by one and repeat steps 2 to 5.
7. Repeat steps 2 to 6 till `countRotated` becomes the array size.

### Complexity Analysis

**Time Complexity-O(N)**

**Space Complexity-O(1)**

## Solution III: Reversal Algorithm

Why does this work ??

### Algorithm

1. Reverse the first `n - k` elements.
2. Reverse the last `k` elements.
3. Reverse the whole array.

### Complexity Analysis

**Time Complexity-O(N)**

**Space Complexity-O(1)**

## Solution IV: GCD Algorithm

Find the GCD of the size of the array and `k`. This divides the array into `gcd` sets with the gap
between each element in the set as `k`. Now, we need to move each element in each of the set by one
step forward (which is `k` elements forward) to complete the rotation.

### Complexity Analysis

**Time Complexity-O(N)**

**Space Complexity-O(1)**

## Solution V: Block Swap Algorithm

TODO

# Shortest Subarray To Be Removed To Make Array Sorted

Problem
Description: [Shortest Subarray To Be Removed To Make Array Sorted](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted)

## Solution I: Using Sliding Window

### Observations

* Draw peaks and valley to better understand the problem and see the edge cases.
* If the elements are equal the subarray is sorted. Need to take care in the code.
* We have three options to choose from:
    * The left sorted subarray
    * The right sorted subarray
    * The sorted subarray formed by removing a subarray from the middle.

### Algorithm

1. Find the length of the left sorted subarray. Let the endpoint be `l`.
2. Find the length of the right sorted subarray. Let the endpoint be `r`.
3. Slide window from `i = 0 to l` and `j = r to n - 1`. Check if the array formed by deleting the
   elements between `i` and `j` is the smallest removed.
4. Return the smallest of the above three options.

### Complexity Analysis

N is the length of the `arr` array.

#### Computational Complexity: O(N)

#### Space Complexity: O(1)

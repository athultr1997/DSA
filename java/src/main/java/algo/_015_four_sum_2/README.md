# Four Sum II

Problem Description: [454. 4Sum II](https://leetcode.com/problems/4sum-ii/)

Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of
tuples (i, j, k, l) such that:

* `0 <= i, j, k, l < n`
* `nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0`

## Solution I: Using Hashing

Algorithm:

* Loop through the first two arrays nums1 and nums2 and store the count of each possible sum with
  one element from nums1 and another from nums2 in a HashMap.
* Now, loop through all possible sum from nums3 and nums4 and check if the negative of their sum is
  present in the Hash Map.
* If it is present, increment the result by its count.
* Return the result.

**TC-O(N^2)**: Due to the two double loops.

**SC-O(N^2)**: Due the number of distinct possibilities of sums of elements of nums1 and nums2.


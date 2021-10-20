# 4SUM

Problem Description: [18. 4Sum](https://leetcode.com/problems/4sum/)

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b],
nums[c], nums[d]] such that:

* 0 <= a, b, c, d < n
* a, b, c, and d are distinct.
* nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

## Solution 1: Using Generalized K-Sum

For kSum, we will have `k - 2` nested loops to enumerate all combinations of `k - 2` values. We can
implement k - 2 loops using a recursion. We will pass the starting point and k as the parameters.
When k == 2, we will call twoSum, terminating the recursion.

1. For the main function:
    * Sort the input array nums, since we are using two pointer appraoch for twoSum.
    * Call kSum with start = 0, k = 4, and target, and return the result.
2. For kSum function:
    * At the start of the kSum function, we will check three conditions:
        1. Have we run out of numbers to choose from? This happens when `start == nums.length`.
           Return result.
        1. Is the smallest number remaining greater than `target / k` ? If so, then any k numbers we
           choose will be too large. Return result.
        1. Is the largest number remaining smaller than target / k? If so, then any k numbers we
           choose will be too small. Return result.
    * If k equals 2, call twoSum and return the result.
    * Iterate i through the array from start:
        * If the current value is the same as the one before, skip it. This is done to remove
          duplicate solutions.
        * Recursively call kSum with `start = i + 1`, `k = k - 1`, and `target - nums[i]`.
        * For each returned subset of values:
            * Include the current value nums[i] into subset.
            * Add subset to the result res.
    * Return the result res.

3. For twoSum function:
    * Set the low pointer lo to start, and high pointer hi to the last index.
    * While low pointer is smaller than high: (The order of the following steps is important!)
        * If the sum of nums[lo] and nums[hi] is less than target, increment lo.
        * Increment lo if the value is the same as for lo - 1 and lo is not start. This is done to
          remove duplication.
        * If the sum is greater than target, decrement hi.
        * Decrement hi if the value is the same as for hi + 1 and hi is not end. This is done to
          remove duplication.
        * Otherwise, we found a pair:
            * Add it to the result res.
            * Decrement hi and increment lo.
            * Return the result res.
    
Instead of using twoSum with two pointers, a hash set based approach can also be used.

**TC-O(N^(k-1))**: There are k-2 loops and twoSum in O(N). For 4Sum it is O(N^3).

**SC-O(N)**: Due to the worst time size of the recursion stack.


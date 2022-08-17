# Minimum Sum of Squared Difference

Problem
Description: [Minimum Sum of Squared Difference](https://leetcode.com/problems/minimum-sum-of-squared-difference/)

## Solution I: Bucket Sorting + Greedy Algorithm

### Algorithm

1. Count the differences between each nums1[i] and nums2[i] and store them into an int[100001], as nums is between 0 and
    100000.
2. Let's look at the example of `nums1 = [1,4,10,12]`, `nums2 = [4,8,6,7]`. `k1=1`, `k2=1`
   Looking at the pairs of abs diff we have `[3,4,4,5]`. So a total of 16 diff points with a total k of 2. As we
   observe, if we use the k operations on the first pair, we can decrease 3 to 1, but this would only help with 3^2 (9)
   -> 1. So we decrease the total sum diff by 8. However, if we operate on the diff of 5, this would have much more
   impact.
   5 - 1 => (4^2)25 - 16 . so we save 9 points by using 1 k. 5 - 2 => (3^2) 25 - 9. So we save 16 points. _This is a
   greedy assumption._
4. As we can see, we need to operate on the highest diff, lowering them.
5. As we have counted them on step #1, we would have an array like this
   [0,0,0,1,2,1] : 1 diff of 3, 2 of 4 and 1 of 5.
6. While k is > 0 (k1 + k2), start from the back (highest) and decrease it one group at a time.
   So make all 5 diffs into 4 diff, only if their cardinal is <= k. If it's greater than k, we can only
   lower k diff to diff -1.
   So [0,0,0,1,2,1] and k = 2 => [0,0,0,1,3,0] and k =1
   We have 3 diff of 4 and just k =1 so we can turn one 4 into a 3.
   => [0,0,0,2,2,0]. Thus. the diff becomes 2 of 3 and 2 of 4.

### Complexity Analysis

#### Computational Complexity

**O(N)**: Depends on the size of the input arrays linearly.

#### Space Complexity

**O(1)**: The space allocated is always 100001 integer array, irrespective of input which is less than this value.

## Solution II: Heap or Priority Queue

TODO

## Solution III: Binary Search

TODO

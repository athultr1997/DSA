# Minimum Absolute Sum of Differences

Problem
Description: [Minimum Absolute Sum of Differences](https://leetcode.com/problems/minimum-absolute-sum-difference/)

## Solution I: Binary Search + Red Black Tree

### Explanation

Let's generate the MAD (Minimum Absolute Differences) of the given input arrays nums1 and nums2. Now we need to find a
MAD array whose sum is minimum by searching the candidate MAD arrays using the transformation allowed. The found MAD
array will have the maximum distance from the MAD we have to minimize.

_Note that its not just the maximum element or maximum difference element which needs to be substituted. Any element can
be replaced to get the minimum MAD._

### Algorithm

1. Find the MAD sum of nums1 and nums2.
2. Add all elements of nums1 to a Red Black Tree (RBT).
3. For each element of nums2, find the closest element in nums1. It could be the ceil or floor in the RBT.
4. Find the pair with minimum difference which will cause the MAD sum to reduce the max.
5. Replace the MAD of the element in the MAD sum by the new reduced sum.

### Complexity Analysis

#### Computational Complexity

**O(NlogN)**: We have to search for the closest element for each element in the RBT.

#### Space Complexity

**O(N)**: Maximum of N elements will be stored in the RBT.

## Related Questions

### Same question with `k` transformations allowed.

* Will have to maintain a priority queue (PQ) of the maximum reductions to the MAD sum and reduce the first `k` elements from
  the PQ.
* Will also need to make sure the same element is not subtracted twice.


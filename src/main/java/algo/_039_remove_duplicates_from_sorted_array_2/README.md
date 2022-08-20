# Remove Duplicates from Sorted Array II

Problem
Description: [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

## Solution I: Two Pointer Approach

### Explanation

* The first pointer denotes the elements which are to be included in the final array.
* The second pointer denotes the traversal of the input array.
* We only need to add an element if the element at the ith position and i+2th position are different because the
  elements between them which is elements at i and i+1 are same. Hence, the element has been repeated more than twice.
* Be careful how the logic works. Can get easily confused if we forget the fact that the elements between the slow and
  the fast pointer are deleted during the traversal.
* Be careful about the edge cases how the return value is exactly the size of the non-duplicate array.
* **Can be generalized to `k` duplicates.**

### Algorithm

1. Point the slow pointer (j) and the fast pointer (i) to the beginning of the input.
2. If the element at i and i + 2 are different swap the element at j with i and increment both i and j.
3. Else if the element at i and i + 2 are the same, increment i.
4. Repeat steps 2 to 4 till the fast pointer reaches the end of input.


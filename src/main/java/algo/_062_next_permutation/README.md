# Next Permutation

Problem
Description: [Next Permutation](https://leetcode.com/problems/next-permutation/)

## Solution I: Two-Pointer Approach

1. Find the first pair `(s[i], s[i + 1])` where `s[i] < s[i+1]`. Mark `k=i`.
2. If no such pair can be found reverse the sequence and return the result.
3. If such a pair exists:
    4. Find the first number greater than `s[k]` between `[k + 1, n - 1]` starting from `n-1`. Mark
       the index `l`.
    5. Swap `s[k]` and `s[l]`.
    6. Reverse the sequence `[k + 1, n - 1]`.

### Observations

1. If the sequence is in descending order, no next permutation is possible, hence have to return the
   numbers sorted in ascending order from left. This is also the reverse of the given permutation.
2. From the right, till the first ascending pair of neighbouring numbers, all the numbers are in
   descending order from right. Hence, they cannot be permuted to create a next sequence. We have to
   include the first ascending pair as well.
3. The permutation that will be next will consist of a rearrangement of '[s[i], s[n - 1]]'. The
   smallest sequence that can be generated from '[s[i], s[n - 1]]' by finding the smallest
   number (`s[j]`) greater that `s[i]` in '[s[i], s[n - 1]]'. Since, '[s[i+1], s[n - 1]]' is sorted
   in descending order from right, the first number greater that `s[i]` from right will be `s[j]`.
4. After swapping `s[i]` and `s[j]`, the sequence '[s[i+1], s[n - 1]]' is not the smallest. Thus, we
   need to reverse '[s[i+1], s[n - 1]]' to create the smallest sequence since '[s[i+1], s[n - 1]]'
   is in descending order from right.
5. This even works if there are duplicate elements in the array.

### Complexity Analysis

#### Computational Complexity: O(N)

N is the length of the array.

#### Space Complexity: O(1)

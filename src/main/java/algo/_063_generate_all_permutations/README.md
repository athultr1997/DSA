# Generate All Permutations

Problem
Description: [Generate All Permutations](https://leetcode.com/problems/permutations)

## Solution I: Use Algorithm From [Next-Permutation](https://leetcode.com/problems/next-permutation/)

### Algorithm

1. Sort the array in ascending order.
2. Run the Next-Permutation algorithm till no ascending pair can be found.
3. Keep adding the next permutation found to the result list.

### Complexity Analysis

#### Computational Complexity: O(N.N! + N.lnN)

There are `N!` permutations to be made. Making one permutation takes `O(N)`. It takes `O(N.lnN)` to
sort the array.

#### Space Complexity: O(1)

No extra space is required.

## Solution II: Optimized [Next-Permutation](https://leetcode.com/problems/next-permutation/)

### Algorithm

Keep running the next permutation algorithm `n!` times.

### Complexity Analysis

#### Computational Complexity: O(N.N!)

There are `N!` permutations to be made. Making one permutation takes `O(N)`.

#### Space Complexity: O(1)

There are no extra spaces required. Extra space for answer does not count.

## Solution III: Backtracking

### Algorithm

1. Initialize an answer array `ans` and an array `curr` to build permutations with.
2. Create a backtrack function that takes `curr` as an argument:
    1. If `curr.length == nums.length`, add a copy of `curr` to `ans` and return.
    2. Iterate over `nums`. For each `num`, if num is not in `curr`, do the following:
        1. Add `num` to `curr` and call `backtrack(curr)`, then remove `num` from `curr`.
3. Call `backtrack` with an initially empty `curr`.
4. Return `ans`.

### Complexity Analysis

#### Computational Complexity: O(N.N!)

There are `N!` permutations to be made. It requires `O(N)` to search the permutation to see if the
next element is present or not.

#### Space Complexity: O(N)

The depth of the recursion call stack is the length of the array which is `O(N)`.

## Clarifications

### Why is there an assumption that the numbers are unique? What happens if they are not?

## Edge Conditions

* Take care to deep copy the array being built to the results array. On failing this, the result
  will all be empty because everything points to an empty structure.
* Need to search the current array being built if it contains an element or not. Find optimized
  function for doing so.

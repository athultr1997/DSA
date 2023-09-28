# Generate All Permutations Having Duplicates

Problem
Description: [Generate All Permutations Having Duplicates](https://leetcode.com/problems/permutations-ii/description/)

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

## Solution II: Using Backtracking with Hashmap

### Algorithm

1. Create a HashTable with the unique numbers to its count of occurrences called `counter`.
2. Initialize an answer array `ans` and an array `curr` to build permutations with.
3. Create a backtrack function that takes `curr` as an argument:
    1. If `curr.length == nums.length`, add a copy of `curr` to `ans` and return.
    2. Iterate over `counter`. For each `num`, if `count` of num is greater than zero, do the
       following:
        1. Add `num` to `curr`.
        2. Reduce count of num in `counters`.
        3. Call `backtrack(curr)`.
        4. Remove `num` from `curr`.
        5. Increase count of num in `counters`.
4. Call `backtrack` with an initially empty `curr`.
5. Return `ans`.

### Explanation

* To avoid generating any redundant permutation is that at each step rather than viewing each number
  as a candidate, we consider each unique number as the true candidate.
* The hash table do not need to list its content in a sorted order. Any order will work. Hence, we
  can use HashMap instead of TreeMap.

### Complexity Analysis

#### Computational Complexity: O(N.N!)

There are `N!` permutations to be made. Making one permutation takes `O(N)`.

#### Space Complexity: O(N)

* First of all, we build a hash table out of the input numbers. In the worst case where each number
  is unique, we would need `O(N)` space for the table.

* Since we applied recursion in the algorithm which consumes some extra space in the function call
  stack, we would need another `O(N)` space for the recursion.

* During the exploration, we keep a candidate of permutation along the way, which takes yet
  another `O(N)`.

* To sum up, the total space complexity would be `O(N)+O(N)+O(N)=O(N)`.


## Solution III: Using Backtracking with Sorting

TODO

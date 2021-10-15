# Two Sum

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two
numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
and numbers[index2] where 1 <= first < second <= numbers.length. Return the indices of the two
numbers, index1 and index2, as an integer array [index1, index2] of length 2. The tests are
generated such that there is exactly one solution. You may not use the same element twice.

## Solution 1

Use two pointers left and right. Increment left if sum of left and right is lower than target. If
sum of left and right is greater decrement right. If the sum is equal to target break and return the
result.

TC - O(N)

SC - O(1)

## Solution 2

Use the same approach of using map in the general TwoSum problem.

TC - O(N)

SC - O(N)
# Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that
they add up to target. You may assume that each input would have exactly one solution, and you may
not use the same element twice. You can return the answer in any order.

## Solution 1

Use map to keep track of elements encountered and search for `target - current` in the map.

TC - O(N)

SC - O(N) 

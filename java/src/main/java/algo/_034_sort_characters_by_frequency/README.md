# Sort Characters By Frequency

Problem
Description: [451. Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)

## Solution I: Using Priority Queue and Hash Map

Algorithm:

1. Create a hash map of the characters in te string, and their frequencies by iterating the given
   string.
1. Create a max priority queue based on the frequency of the characters using the elements from the
   hash map populated in the last step.
1. Pop the top element from the priority queue and add the character to the result frequency times.
1. Keep repeating the last step till the priority queue is empty.
1. Return the result.

**TC-O(NlgN)**: Due to construction of Priority Queue.

**SC-O(N)**: Due to construction of Priority Queue and HashMap.

## Solution II: Using Bucket Sorting

TODO

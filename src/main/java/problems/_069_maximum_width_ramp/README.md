# Maximum Width Ramp

Problem
Description: [Maximum Width Ramp](https://leetcode.com/problems/maximum-width-ramp/description/)

## Solution I: Using Brute Force

### Approach

* For every element find the first element less than or equal to the specified element to its left
  sub-array.
* Keep recording the max difference of the indexes.

### Complexity

#### Time Complexity: O(N^2)

#### Space Complexity: O(1)

## Solution II: Sort the array and use index array

#### Intuition

* Sort the array in ascending order so that more pairs being considered are valid.
* Keep track of the original indexes so that we can calculate the difference between indexes to
  compute the result.
* Should ignore pairs having difference between indexes that are less than zero.
* Keep track of the minimum index encountered to calculate the difference.
    * This works because this difference will be the highest compared to other candidates.
    * For example for `nums = [6,0,8,2,1,5]`, the sorted array of indices is `[1,4,3,5,0,2]`.
      For `index = 2`, only the `index = 0` should be considered. No need of comparing
      with `index = 1` even though it is valid.

### Approach

* Sort the array of indices with weight as `nums` in ascending order.
* Keep track of the minimum index encountered so far.
* For each element calculate the difference with the minimum index encountered so far.

### Complexity

#### Time Complexity: O(N.lgN)

#### Space Complexity: O(N)

## Solution III: Using Minimum Stack

#### Intuition

* Keep the elements that are in decreasing order in the stack.
* Whenever a new element is encountered find the element in the stack that is just smaller than the
  element.
    * Use binary search in the stack to search for the candidate faster.
* Using a stack because only needed to compare with the earliest smallest elements encountered.

### Approach

For each element:

* Add it to the stack if the stack is empty, or if it is smaller than the top element.
* Find the smallest element less than or equal to the current element in the stack and calculate the
  index difference. If it is greater than the result, update the result to the calculated value.

### Complexity

#### Time Complexity: O(N.lgN)

#### Space Complexity: O(N)

## Solution IV: Using Optimized Minimum Stack

#### Intuition

* Add the decreasing elements to the stack in one traversal of the input array. This creates a list
  of potential candidates because it is better to calculate potential answers with these elements
  than others since these elements will be more optimal.
* Start the second traversal of the input array from the end of the array. This creates optimal
  solutions since the difference between indexes will be higher.
    * If the top of the stack is less than the current element, it is a potential solution.
    * Once the top is checked it is popped out. This is because if we do not pop the stack, the next
      element in the traversal will only give a worse solution than the current element in the
      traversal since it is one step closer but the top of the stack is the same.
    * Keep popping the stack until the top is less than equal to the current element.

### Complexity

#### Time Complexity: O(N)

#### Space Complexity: O(N)

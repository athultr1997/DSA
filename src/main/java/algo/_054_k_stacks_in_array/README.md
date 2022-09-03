# Implement K Stacks in an Array

Problem
Description: [Implement K Stacks in an Array](https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/)

## Solution I: Additional Arrays

### Explanation

We need additional arrays to keep the following information:

* `top`: The top pointers of all the `k` arrays.
* `next`: The next pointer of each element in a stack.

We also need an array to store the actual data being pushed into the stacks: `array`.

We also require a variable to store the next free index in the array: `free`.

#### Initialization

* All the elements in the `next` array points to the next index initially.
* All the elements in the `top` array is -1 initially to show that all stacks are empty.
* The `free` variable points to the first free index initially which is zero.

Perform the dry run of the push and pull operations to understand their logic.

### Complexity Analysis

#### Computational Complexity

##### Push

**O(1)**

##### Pop

**O(1)**

#### Space Complexity

**O(N)**

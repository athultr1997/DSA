# Dinner Plates Stack

Problem
Description: [Dinner Plates Stack](https://leetcode.com/problems/dinner-plate-stacks/)

## Solution I: Red-Black-Tree and LinkedList

### Explanation

The stacks can be divided into two types:

1. The stacks which have reached their full capacity called closed-stacks.
2. The stacks which have not reached their full capacity called open-stacks (This set will include the stack at the end
   of the list as well).

Other Observations:

* Since the stacks have to be deleted and inserted from time to time they should be stored in a linked list.
* The indices where the stacks are open should be stored separately in a data structure so that:
    * We can search the least ordered element easily.
    * Delete the least ordered element after that index is full.
    * Insert new indices easily.
* For the above-mentioned reasons we need a Red-Black-Tree (TreeSet) to store the open indices.

### Complexity Analysis

#### Computational Complexity

##### Push

**O(N)**

##### Pop

**O(N)**

##### PopAtStack

**O(N)**

#### Space Complexity

**O(N)**

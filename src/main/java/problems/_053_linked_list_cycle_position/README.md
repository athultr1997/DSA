# Linked List Cycle Position

Problem
Description: [Linked List Cycle Position](https://leetcode.com/problems/linked-list-cycle-ii/)

## Solution I: Floyd's Cycle Finding Algorithm + Circle

### Explanation

Let the distance till the entry be: L1

Let the distance from the entry point till the meeting point be: L2

Let the distance from the meeting point till the entry point in the forward direction be: x

Total distance traveled by the slow pointer will be: d1 = L1 + L2

Total distance traveled by the fast pointer will be: d2 = L1 + L2 + x + L2

Since the slow pointer moves one step and the fast two step each time we have the relation: d2 = 2d1

L1 + L2 + x + L2 = 2 (L1 + L2) => x = L1

Therefore, a pointer needs to move the same distance till the entry point as a pointer that moves from meeting point till
the entry point.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(1)**

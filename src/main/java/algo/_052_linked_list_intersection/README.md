# Intersection of Two Linked Lists

Problem
Description: [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

## Solution I: Two Pointers + Circling

LL: Linked List

### Explanation

We use the fact that:

```
(length(LL1) - (length(LL1) - length(common part))) + length(common part) + (length(LL2) - (length(LL2) - length(common
part))) = (length(LL2) - (length(LL2) - length(common part))) + length(common part) + (length(LL1) - (length(LL1) -
length(common part)))
```

If there is no intersection the algorithm's pointers will be equal because both will be null.

### Algorithm

1. Point one pointer, p1 to the head of LL1 and another pointer p2 to the head of LL2.
2. Iterate the two pointers by one node at a time.
3. Repeat step 2 until the two pointers are equal.
4. During step 2 if any pointer reaches the end of the linked list point it to the head of the other linked list.

### Complexity Analysis

#### Computational Complexity

**O(M + N)**

#### Space Complexity

**O(1)**

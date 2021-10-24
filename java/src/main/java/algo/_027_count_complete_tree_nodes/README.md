# Count Complete Tree Nodes

Problem
Description: [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

Given the root of a complete binary tree, return the number of the nodes in the tree. According to
Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes
inclusive at the last level h. Design an algorithm that runs in less than O(n) time complexity.

## Solution I: Using Recursion (Brute Force)

Visit all the nodes and increment the count by one once a new node is visited.

**TC-O(N)**

**SC-O(N)**

## Solution II: Using properties of complete tree

Algorithm:

1. If the root is null return 0.
1. Check the depth of the left and right subtrees.
1. If they are equal return `2^h - 1`.
1. If they are not equal:
    1. Repeat steps 1 to 3 for the left sub tree.
    1. Repeat steps 1 to 3 for the right sub tree.
    1. Return `1 + nodes of left subtree + nodes of right subtree`.

**TC-O(N)**: h + h-1 + h-2 + ... + 1 = O(h^2) = O(lgN^2)

**SC-O(N)**: O(N)

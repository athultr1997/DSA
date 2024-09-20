# Minimum Absolute Difference in BST

Problem
Description: [530. Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the
values of any two different nodes in the tree.

# Solution I: Inorder Traversal

The minimum difference will be between adjacent values when the values are sorted in increasing
order. The inorder traversal of the BST will visit the nodes in increasing order. While traversing
keep a variable previous which point to the previously visited node.

**TC-O(N)**: Same as that of inorder traversal
**SC-O(N)**: Same as that of inorder traversal

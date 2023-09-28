# Path Sum I

Problem Description: [112. Path Sum](https://leetcode.com/problems/path-sum/)

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
path such that adding up all the values along the path equals targetSum. A leaf is a node with no
children.

## Solution 1: Using DFS

Do a DFS of the tree in any fashion (inorder, preorder, postorder). Add the values of the nodes
encountered during DFS. If at any leaf node the sum is the target sum return true, else return
false. The same can be done by subtracting values of nodes from the target sum.

**TC-O(N)**

**SC-O(N)**

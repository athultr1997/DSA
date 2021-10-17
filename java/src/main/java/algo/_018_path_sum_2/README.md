# Path Sum II

Problem Description: [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/)

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the
sum of the node values in the path equals targetSum. Each path should be returned as a list of the
node values, not node references. A root-to-leaf path is a path starting from the root and ending at
any leaf node. A leaf is a node with no children.

## Solution I: Using DFS and Backtracking

Add the newly visited node to the path. Also, subtract the value of the node from the target sum.
When a leaf node is reached check whether the target sum is zero. If it is zero add the current path
to the result, else return. Remove the lastly added node from the current path.

**TC-O(N^2)**: This is due to the cost of copying nodes.

**SC-O(N)**: Due to the recursion stack which is the height of the tree.

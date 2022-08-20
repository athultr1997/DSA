# Path Sum III

Problem Link: [437. Path Sum III](https://leetcode.com/problems/path-sum-iii/)

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum
of the values along the path equals targetSum. The path does not need to start or end at the root or
a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

## Solution I: Using DFS

For every node, find the target sum using the sum obtained so far from parent nodes and the current
node. Also, find the target sum ignoring the ancestor sums and starting from the current node.

**TC - O(N^2)**: The first DFS will take O(N) and the second DFS will also take O(N). Hence, the
complexity is O(N^2).

**TC - O(N)**: The depth of the recursion stack will be the height of the tree. In worse case, the
tree may be unbalanced.

## Solution II: Using DFS and Memoization

Do a DFS and while doing DFS store the current sum in a map along with its frequencies. When
reaching the next node, check if `currentSum - target` is present in the map. If it is present add
its corresponding frequencies to the result and proceed with dfs. (Try to dry run to visualize
excellently).

**TC-O(N)**: Same TC as that of DFS of tree.

**SC-O(N)**: Same SC as that of DFS of tree.

# House Robber III

Problem Description: [337. House Robber III](https://leetcode.com/problems/house-robber-iii/)

The thief has found himself a new place for his thievery again. There is only one entrance to this
area, called root. Besides the root, each house has one and only one parent house. After a tour, the
smart thief realized that all houses in this place form a binary tree. It will automatically contact
the police if two directly-linked houses were broken into on the same night. Given the root of the
binary tree, return the maximum amount of money the thief can rob without alerting the police.

## Solution I: Using DP with Memoization

The state transition equation for this problem is:

```
f(n) = max(f(n.left) + f(n.right), n.val + f(n.left.right) + f(n.left.left) + f(n.right.left) + f(n.right.right))
     = max(f(children), currentValue + f(grandchildren))
     = max(f(n is not robbed), f(n is robbed))
```

The problem exhibits conditions needed for using DP. Hence, memoization can be used during
recursion. The maximum amount for each node is stored in a hash set after computation and is reused.

**TC - O(N)**: Each node will be visited once.

**SC - O(N)**: The recursion stack will have max height of the tree in worse case which is N.

## Solution II: Using DP with Tabular Approach

For every node we need to store the maximum amount that could be stolen without including it and by
including it.

```
Input: [3,4,5,1,3,null,1]
 input tree              dp tree
     3                  [3+3+1,4+5]
    / \                /        \
   4   5            [4,3]      [5,1]
  / \   \          /     \          \
 1   2   1      [1,0]    [2,0]     [1,0]
                / \       /  \        /  \
            [0,0] [0,0] [0,0] [0,0]  [0,0] [0,0]

```



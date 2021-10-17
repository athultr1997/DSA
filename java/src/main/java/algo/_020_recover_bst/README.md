# Recover Binary Search Tree

Problem Description: [99. Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/)

## Solution I:

Do normal inorder traversal of the tree, so that the nodes are visited in increasing order. The
nodes that are swapped will violate the increasing order. To check for violation the previous node
should be stored. The first and the second node that violates the increasing order property should
be stored. After the traversal swap the two nodes that were stored.

* Edge Cases:
    * Do not do if-else, do an if-if. This is needed if the swapped nodes are right next to each
      other.
    * For the first element it is a previous node while for the second element it is the current
      node that needs to be stored.

**TC-O(N)**

**SC-O(N)**

## Solution II: Morris Traversal

TODO

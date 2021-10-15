# Two Sum BST

Given the root of a Binary Search Tree and a target number k, return true if there exist two
elements in the BST such that their sum is equal to the given target.

Link - [653. Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)

## Solution 1

Do any traversal of the BST using recursion and maintain a set that contains the numbers encountered
so far. Whenever a new node is reached check whether `target - currentNode.value` is present in the
set.

TC - O(N)

SC - O(N)

## Solution 2

Use BST iterator approach discussed in the
problem [173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)
. Create two iterators left and right. The left iterator will traverse the BST in inorder fashion
going across elements in increasing order. The right iterator will traverse the BST in reverse
inorder fashion going across the elements in decreasing order. So, this problem reduces to two sum
in a sorted array which is solved using two
pointers [167. Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
.

TC - O(N)

SC - O(lgN)

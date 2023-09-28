# Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary
search tree (BST):

`BSTIterator(TreeNode root)`: Initializes an object of the BSTIterator class. The root of the BST is
given as part of the constructor. The pointer should be initialized to a non-existent number smaller
than any element in the BST.

`boolean hasNext()`: Returns true if there exists a number in the traversal to the right of the
pointer, otherwise returns false.

`int next()`: Moves the pointer to the right, then returns the number at the pointer. Notice that by
initializing the pointer to a non-existent smallest number, the first call to next() will return the
smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number
in the in-order traversal when next() is called.

Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is
the height of the tree?

## Solution 1

Take the algorithm for normal inorder traversal and fit it into various functions.

```
while(current != null || !stack.isEmpty()) {
    while (current != null) {
        stack.push(current);
        current = current.left;
    }
    current = stack.pop();
    print(current);
    current = current.right;
}
```

TC

* `boolean hasNext()`: O(1)
* `int next()`: O(1) average case (All the node will be pushed to the stack for only one time, so
  the average complexity of the next calling is O(1) amortized on single node)

SC

* `boolean hasNext()`: O(1)
* `int next()`: O(h)

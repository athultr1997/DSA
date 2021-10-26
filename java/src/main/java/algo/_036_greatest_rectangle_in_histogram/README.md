# Largest Rectangle in Histogram

Problem
Description: [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

Given an array of integers heights representing the histogram's bar height where the width of each
bar is 1, return the area of the largest rectangle in the histogram.

## Solution I: Using Dynamic Programming

For every bar `i` we need to know its left and right boundaries. The left boundary `l` is the index
of the first bar to the left with `height[l] < height[i]`. The right boundary `r` is the index of
the first bar to the right with `height[r] < height[i]`. Then we can calculate the area as follows:

```
area = height[i] * (r - l - 1)
```

To calculate the boundaries for each bar `i` we can use a nested loop. The time complexity of this
approach will be **O(N^2)**.

```
leftBoundaries[0] = -1;
for (int i = 1; i < n; ++i) {
    int j = i - 1;
    while (height[j] >= height[i]) {
        j--;
    }
    leftBoundaries[i] = j;
}
```

There are overlapping subproblems in this case which are being computed again. Therefore, we can use
dynamic programming to reduce the complexity to **O(N)**. This will reduce the complexity because
each computed left boundaries will be used only at most once.

```
leftBoundaries[0] = -1;
for (int i = 1; i < n; ++i) {
    int j = i - 1;
    while (height[j] >= height[i]) {
        j = leftBoundaries[j];
    }
    leftBoundaries[i] = j;
}
```

Once we know the left and right boundaries of each bar `i`, we can calculate the area for each bar
and find maximum.

### Complexity Analysis

**Time Complexity-O(N)**

**Space Complexity-O(N)**

## Solution II: Using Stack

For every bar we need to know its left and right boundaries. To find the left boundaries of the
current bar we can use a stack. The stack always contains the bars in increasing order of height of
bars. For the current bar on top the left boundary will be given by the bar beneath it.

Implementation Notes:

* Store indexes in the stack instead of actual elements.
* Check for conditions when the stack is empty.
* Boundary conditions needs to be handled properly for both left and right.

### Complexity Analysis

**Time Complexity-O(N)**: All the bars are inserted in the stack at least once.

**Space Complexity-O(N)**: In the worst case all elements could be in the stack at once if the bars
are in increasing order of height.


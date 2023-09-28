# 0 1 Matrix

Problem
Description: [0 1 Matrix](https://leetcode.com/problems/01-matrix/description/)

## Solution I: Brute-Force Approach

### Explanation

For every cell, iterate over the grid and find the distance to all the other cells. Keep track of
the minimum distance to `0` cell while doing so.

### Complexity Analysis

#### Computational Complexity: O((m.n)^2)

The total number of cells is `m.n`. For each cell we have to check distance to all the other cells
which is also `m.n`.

#### Space Complexity: O(1)

No extra space is consumed

## Solution II: Unoptimized BFS

### Explanation

For every cell start BFS to the nearest `0` cell and record the depth as the distance to it.

### Complexity Analysis

#### Computational Complexity: O((m.n)^2)

#### Space Complexity: O(m.n)

## Solution III: Optimized BFS

### Explanation

1. Initialize a distance grid with initial values infinity for `1` and 0 for `0` cells.
2. Find all the `0` cells. Add them to a queue. They will be the starting sources of a multi-source
   BFS.
3. While walking, update the distance at each cell visited if it is lower than the distance present
   there.

### Complexity Analysis

#### Computational Complexity: O(m.n)

#### Space Complexity: O(m.n)

## Solution IV: DP

### Explanation

The state transition equation:

```
f[i][j] = min(f[i-1][j], f[i+1][j], f[i][j-1], f[i][j+1])
```

The minimum values for all the four neighbours won't available in a single walk of the grid. It will
only be partially ready depending on which corner the walk is starting from. If the walk starts from
the top left corner only the top and the left neighbour values will be ready. In this case we have
to do another walk in the reverse order from the bottom corner. In the second walk, the bottom and
the right neighbours will be ready.

### Complexity Analysis

#### Computational Complexity: O(m.n)

#### Space Complexity: O(1)

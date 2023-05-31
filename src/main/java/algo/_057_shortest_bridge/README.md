# Shortest Bridge

Problem
Description: [Shortest Bridge](https://leetcode.com/problems/shortest-bridge/description/)

## Solution I: Using BFS and DFS

### Explanation

1. Find any cell that is a land cell. This is needed because we need a starting point to calculate
   the shortest distance between two entities. In this case the two entities are islands. Since any
   cell could be a land cell, a step-by-step walk of the grid will suffice for this.
2. Expand from the first land cell to find all the cells which are part of the discovered island.
   Both BFS and DFS can be used for doing this. Store all the island cells.
3. Start performing multi-source BFS from all the discovered land cells till a land cell is found.
   The number of iterations taken will be the shortest distance.

### Complexity Analysis

#### Computational Complexity: O(N^2)

#### Space Complexity: O(N^2)

If one island is big enough to cover almost whole grid. All of it will be added to the starting
queue for BFS.

## Solution II: Using DP

// TODO

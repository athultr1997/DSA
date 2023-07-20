# Detonate the Maximum Bombs

Problem
Description: [Detonate the Maximum Bombs](https://leetcode.com/problems/detonate-the-maximum-bombs/description/)

## Solution I: Using BFS

### Explanation

1. Convert the given data into a directed graph. There is an edge (u,v) only if u can detonate v.
2. Do a BFS of the graph starting from each node with the visited array reset for each BFS.

### Why use adjacency matrix instead of adjacency list ?

The size of nodes in graph is less in given question. Only 100. So can use adjacency matrix easily.

### Why is it a directed graph instead of a undirected graph ?

If a bomb v can detonate a bomb u it does not mean the bomb u can detonate the bomb u. The relation
is not symmetric.

### Why is the visited array reset?

If we use a global visited array and then when we start from a node it might not have any outdegrees
and we will mark it as visited. However, it might have an indegree and can be detonated by another
bomb. Since the goal is to find the largest detonation chain visited array should be reset.

## Solution II: Using DFS

Same as above but uses DFS.

### Complexity Analysis

#### Computational Complexity: O(n^3)

BFS has a complexity of O(n^2). We have to perform BFS from each node n. Hence the overall
complexity will be O(n^3).

#### Space Complexity: O(n^2)

The adjacency matrix will have a storage of O(n^2).

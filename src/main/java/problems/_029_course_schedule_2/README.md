# Course Schedule II

Prerequisites: [Course Schedule I](https://github.com/athultr1997/DSA/tree/main/java/src/main/java/algo/_028_course_schedule)

Problem Description: [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)

## Solution I: Using Kahn's Algorithm

### Algorithm

Construct a graph from the given input as edges. Use the Kahn's Algorithm for topological sorting.
If no topological sort is possible return empty list. Else return the topological sort.

### Complexity Analysis

V represents the number of vertices and E represents the number of edges.

**Time Complexity: O(V + E)**  We pop each node exactly once from the zero in-degree queue and that
gives us V. Also, for each vertex, we iterate over its adjacency list and in totality, we iterate
over all the edges in the graph which gives us E. Hence, O(V+E).

**Space Complexity: O(V + E)** We use an intermediate queue data structure to keep all the nodes
with 0 in-degree. In the worst case, there won't be any prerequisite relationship, and the queue
will contain all the vertices initially since all of them will have 0 in-degree. That gives us O(V).
Additionally, we also use the adjacency list to represent our graph initially. The space occupied is
defined by the number of edges because for each node as the key, we have all its adjacent nodes in
the form of a list as the value. Hence, O(E). So, the overall space complexity is O(V+E). To sum up,
the overall space complexity is O(V+E).

## Solution II: Using DFS

TODO

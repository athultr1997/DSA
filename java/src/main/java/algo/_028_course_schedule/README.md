# Course Schedule

Problem Description: [207. Course Schedule](https://leetcode.com/problems/course-schedule/)

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are
given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
bi first if you want to take course ai. For example, the pair [0, 1], indicates that to take course
0 you have to first take course 1. Return true if you can finish all courses. Otherwise, return
false.

## Solution I: Topological Sort Using DFS

Build a graph from the input and do a topological sort of the graph using DFS to detect cycles. If
the graph can be topological sorted, the courses can be finished. Else, the courses cannot be
finished.

**TC-O(V + E)**

**SC-O(V)**

## Solution II: Topological Sort using Kahn's Algorithm

Implement the Kahn's Algorithm. If the count of visited nodes is not equal to the number of courses
return false. Else return true. This is more of a BFS solution.

**TC-O(V + E)**

**SC-O(V)**

### References:

[1] [Kahn’s algorithm for Topological Sorting](https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/)

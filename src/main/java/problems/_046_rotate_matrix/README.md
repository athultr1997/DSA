# Rotate Matrix

Problem
Description: [Rotate Matrix](https://leetcode.com/problems/rotate-image/)

## Solution I: Following Rotation Pattern

### Explanation

Do a dry run of the algorithm and notice the movement of the data. Rotate each layer of the matrix by 90 degrees. Will
need two loops.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(1)**

## Solution II:

## Explanation

Solution I is a pattern recognition and is not intuitive and hard to code and remember. We can use the fact that the
transpose + reverse of a matrix is the matrix rotated by 90 degrees. This is how matrix algebra rotates matrices. The
algorithm is easier to reason about and code. The downside is that all the elements will be visited twice. The
complexities are the same as that of above.


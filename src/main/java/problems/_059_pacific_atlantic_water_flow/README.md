# Pacific Atlantic Water Flow

Problem
Description: [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)

## Solution I: Using BFS

### Explanation

Check the flow from ocean to the island not vice-versa.

1. Start BFS from each cell on the boundary of the pacific ocean using a visited array.
2. Start BFS from each cell on the boundary of the atlantic ocean using a different visited array.
3. Find the cells visited by the above two BFSs. They constitute the result.

#### Why can't we use DP for this problem like 0-1 Matrix problem?

Not able to decompose problem into smaller problems. The smaller problem may require the bigger
problem to be solved first.

#### Should we use a OR binary operation and create 4 values for different states in a matrix?

Not needed. The two visited arrays are enough. Such an array will consume even more space.

#### Should we use a multi-source BFS like in the Shortest Bridge problem ?

This is not needed because we already know the source from which to start the BFS. In the other
problem we did not know the starting points.

#### Repetition of corner cells

The corner cells are added into the bfs source nodes twice. There is no correctness issue with this
because it has already been marked as visited.

### Complexity Analysis

#### Computational Complexity: O(mn)

#### Space Complexity: O(mn)

Space needed for the visited arrays. The queue may also grow to this.


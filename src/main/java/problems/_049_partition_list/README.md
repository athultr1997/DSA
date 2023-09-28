# Partition List

Problem
Description: [Partition List](https://leetcode.com/problems/partition-list/solution/)

## Solution I: Concatenate and Substring

### Explanation

Create two separate lists and join them in the end. One of the list will be the ones having nodes having value less than
the partition value. The other list will contain nodes with values greater than or equal to the partition value. Use a
dummy node in the two new created lists so that the complications are less. Do not create new nodes, reuse the existing
ones by changing its pointers.

### Complexity Analysis

#### Computational Complexity

**O(N)**

#### Space Complexity

**O(1)**

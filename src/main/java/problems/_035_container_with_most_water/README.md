# Container With Most Water

Problem
Description: [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find
two lines, which, together with the x-axis forms a container, such that the container contains the
most water. Notice that you may not slant the container.

## Solution I: Greedy Two Pointer Approach

### Greedy Choice Justification

1. The widest container (using first and last line) is a good starting candidate, because of its
   width. Its water level is the height of the smaller one of first and last line.
1. All other containers are less wide and thus would need a higher water level in order to hold more
   water.
1. The smaller one of first and last line doesn't support a higher water level and can thus be
   safely removed from further consideration.

### Algorithm

1. Initialize variables `left` to the left most element, `right` to the rightmost element and the
   max area as negative infinity.
1. Calculate the current area using width as the difference between `left` and `right`, and the
   height as the minimum of the elements located at `left` and `right`.
1. Update the max value of area if the current area is greater than the maximum encountered so far.
1. If the height of `left` is less than `right`, increment `left`, else decrement `right`. (Greedy
   Choice)
1. Repeat steps 2 to while `left` is less than `right`.

### Complexity Analysis

**Time Complexity-O(N)**

**Space Complexity-O(1)**


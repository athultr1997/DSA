# Course Schedule III

Problem Description: [630. Course Schedule III](https://leetcode.com/problems/course-schedule-iii/)

There are n different online courses numbered from 1 to n. You are given an array courses where
`courses[i] = [duration_i, lastDay_i]` indicate that the ith course should be taken continuously for
duration_i days and must be finished before or on lastDay_i. You will start on the 1st day, and you
cannot take two or more courses simultaneously. Return the maximum number of courses that you can
take.

## Similar Problems:

* [Job Sequencing Problem](https://www.geeksforgeeks.org/job-sequencing-problem/)
* [Weighted Job Scheduling](https://www.geeksforgeeks.org/weighted-job-scheduling/)

## Solution I: Brute Force

Find all the permutations of the courses that can be taken without collision and keep track of the
maximum number of courses that can be taken.

### Complexity Analysis

N is the number of courses

**Time Complexity-O((N+1)!)** A total of N! permutations are possible and for each permutation we
scan the permutation to find the number of non colliding courses.

**Space Complexity-O(N)** Due to the depth of the recursion stack in the worst case.

## Solution II: Recursion With Memoization

Consider any two courses: (a, x) and (b, y) with x < y and a < x and b < y. Then the following
conditions arise:

1. **a + b <= x**: Can take two options by taking the courses in any order.
2. **a + b > x, a > b, a + b <= y**: Can take two options only be taken by taking a before b.
3. **a + b > x, b > a, a + b <= y**: Can take two options only be taken by taking a before b.
3. **a + b > y**: Only one option can be taken out of a and b.

We can conclude that it is always better to take a course with smaller end day before taking a
course with a larger end day. Therefore, we can sort the given array in increasing order of its
lastDay, and try to take courses in serial order from it.

### Algorithm

Use the recursive formula to calculate the maximum number of courses:

```
schedule(courses, i, time) = max(schedule(courses, i + 1, time + duration_i), schedule(courses, i + 1, time)
                           = max(including course i, without including course i)
```

Course `i` can only be included if `time + duration_i < end_day_i`. The recursive formula can be
optimized using memoization to avoid repetitive calculations. Using memoization drastically reduces
the search space and complexity from O(2^N) without memoization.

### Complexity Analysis

N is the number of courses. d is the maximum value of the end_day among all the end_day's

**Time Complexity-O(N\*d)**: Array of size n*d is filled once. This is because the complexity
without memoization will be O(2^N) and memoization will surely limit it to O(Nd).

**Space Complexity-O(N\*d)**: Array of size N*d is used.

## Solution III: Iterative Approach

It is always better to replace a course that has been taken with a course having longer duration.
This will give more time for the remaining courses to fit in. By replacing the jth course, with the
ith course of a relatively smaller duration, we can increase the time available for upcoming courses
to be taken. An extra duration_j - duration_i time can be made available by doing so. If such a
course, max_i, is found, we remove this course from the taken courses and consider the current
course as taken. We also mark this course with -1 to indicate that this course has not been taken
and should not be considered in the future again for replacement. If such a course isn't found, we
can't take the current course at any cost. Thus, we mark the current course with -1 to indicate that
the current course has not been taken.

### Algorithm

1. Initialize time = 0 and count = 0
1. Check if the current course can be taken using `time + duration_i < end_day_i`
1. If it can be taken, increment count by 1 and time by duration_i.
1. If it cannot be taken:
    1. Search for a course j that has already been taken between 0, and i which has maximum of
       duration_j > duration_i.
    1. If such a course is found, replace the course j with i. Mark -1 on j.
    1. If no such course is found, do not take course_i. Mark -1 on i.
1. Repeat steps 2 to 4 till all the courses are visited.

### Complexity Analysis

N is the number of courses.

**Time Complexity-O(N^2)**: 1 + 2 + + ... + n - 1 = n (n + 1) / 2 = O(N^2). In each step the
previous i elements are being visited.

**Space Complexity-O(1)**: Constant extra space is needed.

## Solution IV: Optimized Iterative Approach

TODO

## Solution V: Approach With Extra List

TODO

## Solution VI: Using Priority Queue

### Algorithm

1. Initialize time = 0, count = 0, and a max heap ordered by duration.
1. Check if the current course can be taken using `time + duration_i < end_day_i`
1. If it can be taken, increment count by 1 and time by duration_i.
1. Add the course to the max heap.
1. If it cannot be taken:
    1. Get the top of the max heap. This is the course j that has already been taken between 0, and
       i which has maximum of duration_j > duration_i.
    1. If the duration of top is greater than duration_i, pop the top element, and add the current
       course i to the max heap.
    1. If no such course is found, do not take course_i. Skip it.
1. Repeat steps 2 to 4 till all the courses are visited.
1. The max heap's size will be the maximum courses that can be taken.

### Complexity Analysis

**Time Complexity-O(NlgN)**: At most nn elements are added to the queue. Adding each element is
followed by heapification, which takes O(lgN) time.

**Space Complexity-O(N)**: The max heap containing the durations of the courses taken can have at
most N elements.
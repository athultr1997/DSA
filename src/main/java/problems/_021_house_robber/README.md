# House Robber

Problem Description: [198. House Robber](https://leetcode.com/problems/house-robber/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount
of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
have security systems connected, and it will automatically contact the police if two adjacent houses
were broken into on the same night. Given an integer array nums representing the amount of money of
each house, return the maximum amount of money you can rob tonight without alerting the police.

## Solution I: Using DP

The state transition equation for this problem is:

```
f(i) = max(f(i-1), f(i - 2) + nums[i])
```

The maximum amount of money robbed till house i is the maximum of:

* `f(i-1)`:The maximum amount robbed till house i-1 and without robbing house i (since robbing house
  i and i-1 can trip the alarm)
* `f(i - 2) + nums[i]`: Robbing house i and the house i - 2.

Since only two previous states are used, two variables will suffice. There is no need of array. This
will reduce the space complexity to O(1).

Base Cases:

* Initialize all variables to zero.


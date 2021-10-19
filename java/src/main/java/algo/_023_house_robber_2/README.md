# House Robber II

Problem Description: [213. House Robber II](https://leetcode.com/problems/house-robber-ii/)

You are a professional robber planning to rob houses along a street. Each house has a certain amount
of money stashed. All houses at this place are arranged in a circle. That means the first house is
the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it
will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum
amount of money you can rob tonight without alerting the police.

# Solution I: DP and Breaking the Circle

The first house, and the last house cannot be robbed together because they are adjacent in a circle.
Therefore, we break the problem into two normal house robber problem as follows (0-indexed houses):

* Rob the houses between `0` to `n-2`
* Rob the houses between `1` to `n-1`

The maximum of the above two will be the required answer. The above problem can be solved using DP
as discussed
in [House Robber I](https://github.com/athultr1997/DSA/tree/main/java/src/main/java/algo/_021_house_robber)
. This break can be done equivalently between any two adjacent houses but `0` and `n-1` are better
to program for.

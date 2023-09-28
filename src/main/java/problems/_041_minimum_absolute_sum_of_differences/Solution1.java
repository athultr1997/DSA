package problems._041_minimum_absolute_sum_of_differences;

import java.util.TreeSet;


public class Solution1 {
  public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
    int n = nums1.length;
    long sum = 0;
    TreeSet<Integer> set = new TreeSet<Integer>();
    for (int i = 0; i < n; ++i) {
      sum += Math.abs(nums1[i] - nums2[i]);
      set.add(nums1[i]);
    }

    int maxDiff = 0;
    for (int i = 0; i < n; ++i) {
      Integer ceil = set.ceiling(nums2[i]);
      Integer floor = set.floor(nums2[i]);
      int diff = Math.abs(nums1[i] - nums2[i]);
      int max = 0;
      if (diff != 0) {
        if (ceil != null) {
          int val1 = Math.abs(nums2[i] - ceil);
          max = Math.max(max, diff - val1);
        }
        if (floor != null) {
          int val2 = Math.abs(nums2[i] - floor);
          max = Math.max(max, diff - val2);
        }
        maxDiff = Math.max(maxDiff, max);
      }
    }

    return (int) ((sum - maxDiff) % 1000000007);
  }
}

package problems._040_minimum_sum_of_squared_distance;

public class Solution1 {
  public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
    int kSum = k1 + k2;
    int n = nums1.length;
    int[] diffs = new int[100001];
    int diff = 0;
    int maxDiff = 0;
    for (int i = 0; i < n; ++i) {
      diff = Math.abs(nums1[i] - nums2[i]);
      diffs[diff]++;
      if (diff > maxDiff) {
        maxDiff = diff;
      }
    }

    for (int i = maxDiff; i > 0 && kSum > 0; --i) {
      if (kSum > diffs[i]) {
        diffs[i - 1] += diffs[i];
        kSum -= diffs[i];
        diffs[i] = 0;
      } else {
        diffs[i - 1] += kSum;
        diffs[i] -= kSum;
        kSum = 0;
      }
    }

    long result = 0;
    for (int i = maxDiff; i > 0; --i) {
      if (diffs[i] > 0) {
        result += (diffs[i] * Math.pow(i, 2));
      }
    }
    return result;
  }
}

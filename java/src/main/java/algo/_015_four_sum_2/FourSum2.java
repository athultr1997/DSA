package algo._015_four_sum_2;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> sum1And2 = new HashMap<>();
    for (int i1 : nums1) {
      for (int i2 : nums2) {
        int sum = i1 + i2;
        int count = sum1And2.getOrDefault(sum, 0);
        sum1And2.put(sum, count + 1);
      }
    }
    int result = 0;
    for (int i3 : nums3) {
      for (int i4 : nums4) {
        int count = sum1And2.getOrDefault(-i3 - i4, 0);
        result += count;
      }
    }
    return result;
  }

}

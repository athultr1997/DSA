package algo._010_two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    int[] result = new int[2];
    Map<Integer, Integer> S = new HashMap<>(n, 1);
    for (int i = 0; i < n; ++i) {
      Integer x = S.get(target - nums[i]);
      if (x != null) {
        result[0] = i;
        result[1] = x;
        return result;
      }
      S.put(nums[i], i);
    }
    return null;
  }

}

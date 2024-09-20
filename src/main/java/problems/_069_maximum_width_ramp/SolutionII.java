package problems._069_maximum_width_ramp;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {

  public int maxWidthRamp(int[] nums) {
    int n = nums.length;
    int result = 0;
    List<Integer> stack = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      if (stack.isEmpty() || nums[i] < nums[stack.get(stack.size() - 1)]) {
        stack.add(i);
      } else {
        int l = 0;
        int r = stack.size() - 1;
        int m;
        while (l < r) {
          m = l + (r - l) / 2;
          if (nums[stack.get(m)] <= nums[i]) {
            r = m;
          } else {
            l = m + 1;
          }
        }
        result = Math.max(result, i - stack.get(l));
      }
    }

    return result;
  }

}

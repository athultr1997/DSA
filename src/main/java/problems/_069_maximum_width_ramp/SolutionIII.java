package problems._069_maximum_width_ramp;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionIII {

  public int maxWidthRamp(int[] nums) {
    Deque<Integer> S = new LinkedList<>();
    int n = nums.length;
    int res = 0;

    // First traversal for storing decreasing elements from start of array.
    for (int i = 0; i < n; ++i) {
      if (S.isEmpty() || nums[S.peekLast()] > nums[i]) {
        S.addLast(i);
      }
    }

    // Second traversal from end of array for finding possible solutions.
    for (int i = n - 1; i >= 0; --i) {
      while (!S.isEmpty() && nums[S.peekLast()] <= nums[i]) {
        res = Math.max(res, i - S.peekLast());
        S.removeLast();
      }
    }

    return res;
  }


}

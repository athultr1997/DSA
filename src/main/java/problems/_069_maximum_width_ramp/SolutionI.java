package problems._069_maximum_width_ramp;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionI {

  public int maxWidthRamp(int[] nums) {
    int n = nums.length;
    Integer[] indexes = new Integer[n];

    for (int i = 0; i < n; ++i) {
      indexes[i] = i;
    }

    Arrays.sort(indexes, new WidthRampComparator(nums));

    // The positive infinity in this case is n since min records indexes
    int min = n;
    int result = 0;

    for (int i = 0; i < n; ++i) {
      result = Math.max(result, indexes[i] - min);
      min = Math.min(min, indexes[i]);
    }

    return result;
  }

  private class WidthRampComparator implements Comparator<Integer> {

    private int[] nums;

    public WidthRampComparator(int[] nums) {
      this.nums = nums;
    }

    public int compare(Integer n1, Integer n2) {
      return Integer.compare(nums[n1], nums[n2]);
    }
  }

}

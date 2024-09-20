package algorithms._001_binary_search;

public class PredecessorOfTargetI {

  public int search(int[] nums, int target) {
    int n = nums.length;
    int l = 0;
    int r = n;
    int m = 0;

    while (l < r) {
      m = l + (r - l) / 2;
      if (nums[m] >= target) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    return nums[m] == target ? l : l - 1;
  }

}

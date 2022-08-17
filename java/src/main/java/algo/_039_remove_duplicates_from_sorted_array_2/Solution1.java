package algo._039_remove_duplicates_from_sorted_array_2;

public class Solution1 {
  public int removeDuplicates(int[] nums) {
    int slow = 0;
    int n = nums.length;
    for (int fast = 0; fast < n; ++fast) {
      if (fast + 2 < n && nums[fast] == nums[fast + 2]) {
        continue;
      }
      else {
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }
}

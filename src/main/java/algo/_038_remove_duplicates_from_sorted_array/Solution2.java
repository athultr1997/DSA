package algo._038_remove_duplicates_from_sorted_array;

public class Solution2 {
  public int removeDuplicates(int[] nums) {
    int start = 0;
    int n = nums.length;
    for(int end = 1; end < n; end++) {
      if (nums[end] != nums[end - 1]) {
        start++;
        nums[start] = nums[end];
      }
    }
    return start + 1;
  }
}

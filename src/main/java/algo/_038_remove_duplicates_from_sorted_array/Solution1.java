package algo._038_remove_duplicates_from_sorted_array;

public class Solution1 {

  public int removeDuplicates(int[] nums) {
    int start = 0;
    int end = 1;
    int n = nums.length;
    int k = 1;
    while(end < n) {
      if (nums[end] != nums[end - 1]) {
        start++;
        nums[start] = nums[end];
        ++k;
      }
      end++;
    }
    return k;
  }

}

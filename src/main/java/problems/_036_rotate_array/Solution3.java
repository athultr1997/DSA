package problems._036_rotate_array;

public class Solution3 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;
    reverse(nums, 0, n - k - 1, n);
    reverse(nums, n - k, n - 1, n);
    reverse(nums, 0, n - 1, n);
  }

  private void reverse(int[] nums, int start, int end, int n) {
    int tmp;
    while (start < end) {
      tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }

}

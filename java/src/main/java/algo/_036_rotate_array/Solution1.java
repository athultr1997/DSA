package algo._036_rotate_array;

public class Solution1 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] copy = new int[n];
    System.arraycopy(nums, 0, copy, 0, n);
    for (int i = 0; i < n; ++i) {
      nums[(i + k) % n] = copy[i];
    }
  }

}

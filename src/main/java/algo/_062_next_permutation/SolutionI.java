package algo._062_next_permutation;

public class SolutionI {

  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int k;
    int l;

    for (k = n - 2; k >= 0; --k) {
      if (nums[k] < nums[k + 1]) {
        break;
      }
    }

    if (k >= 0) {
      for (l = n - 1; l > k; --l) {
        if (nums[l] > nums[k]) {
          break;
        }
      }
      swap(nums, k, l);
    }
    reverse(nums, k + 1, n - 1);
  }

  void reverse(int[] nums, int start, int end) {
    for (int i = 0; i <= (end - start) / 2; ++i) {
      swap(nums, start + i, end - i);
    }
  }

  void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}

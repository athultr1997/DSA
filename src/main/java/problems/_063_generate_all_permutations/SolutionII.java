package problems._063_generate_all_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionII {

  public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
    List<List<Integer>> permutations = new ArrayList<>();
    for (int i = 0; i < factorial(n); ++i) {
      permutations.add(nextPermutation(nums));
    }
    return permutations;
  }

  private int factorial(int n) {
    return n == 1 ? 1 : n * factorial(n - 1);
  }

  public List<Integer> nextPermutation(int[] nums) {
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
    return Arrays.stream(nums).boxed().toList();
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

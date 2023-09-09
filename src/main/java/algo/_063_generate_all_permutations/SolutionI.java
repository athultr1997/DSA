package algo._063_generate_all_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionI {

  public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
    int k;
    List<List<Integer>> permutations = new ArrayList<>();

    // Sort the array in ascending order using inbuilt sorting library.
    Arrays.sort(nums);
    permutations.add(Arrays.stream(nums).boxed().toList());

    while (true) {
      for (k = n - 2; k >= 0; k--) {
        if (nums[k] < nums[k + 1]) {
          break;
        }
      }
      if (k >= 0) {
        permutations.add(permute(nums, k));
      } else {
        return permutations;
      }
    }
    // return permutations;
  }

  private List<Integer> permute(int[] nums, int k) {
    int n = nums.length;
    int l;
    for (l = n - 1; l > k; --l) {
      if (nums[l] > nums[k]) {
        break;
      }
    }
    swap(nums, k, l);
    reverse(nums, k + 1, n - 1);
    return Arrays.stream(nums).boxed().toList();
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private void reverse(int[] nums, int start, int end) {
    for (int k = 0; k <= (end - start) / 2; ++k) {
      swap(nums, start + k, end - k);
    }
  }

}

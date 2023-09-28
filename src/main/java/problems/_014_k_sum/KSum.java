package problems._014_k_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 4, 0);
  }

  private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
    List<List<Integer>> result = new ArrayList<>();
    if (start == nums.length) {
      return result;
    }
    if (nums[start] > target / k) {
      return result;
    }
    if (nums[nums.length - 1] < target / k) {
      return result;
    }
    if (k == 2) {
      return twoSum(nums, target, start);
    }
    for (int i = start; i < nums.length; ++i) {
      if (i != start && nums[i - 1] == nums[i]) {
        continue;
      }
      List<List<Integer>> subResult = kSum(nums, target - nums[i], k - 1, i + 1);
      for (List<Integer> subset : subResult) {
        List<Integer> sol = new ArrayList<>();
        sol.add(nums[i]);
        sol.addAll(subset);
        result.add(sol);
      }
    }
    return result;
  }

  private List<List<Integer>> twoSum(int[] nums, int target, int start) {
    int l = start;
    int r = nums.length - 1;
    List<List<Integer>> result = new ArrayList<>();
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (l != start && nums[l - 1] == nums[l]) {
        l++;
      } else if (r != nums.length - 1 && nums[r + 1] == nums[r]) {
        r--;
      } else if (target == sum) {
        result.add(Arrays.asList(nums[l], nums[r]));
        l++;
        r--;
      } else if (target < sum) {
        r--;
      } else {
        l++;
      }
    }
    return result;
  }

}

package problems._066_partition_k_equal_subsets;

public class SolutionI {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int n = nums.length;
    int sum = 0;

    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }

    int target = sum / k;
    int totalSubsets = 1 << n;
    int[] dp = new int[totalSubsets];

    for (int i = 0; i < totalSubsets; ++i) {
      dp[i] = -1;
    }

    dp[0] = 0;
    for (int mask = 0; mask < totalSubsets; ++mask) {
      for (int j = 0; j < n; ++j) {
        // the mask is not valid
        if (dp[mask] == -1) {
          continue;
        }
        // check if the jth bit is set
        if ((mask & (1 << j)) != 0) {
          continue;
        }
        // the subset sum is greater than target
        if (dp[mask] + nums[j] > target) {
          continue;
        }
        dp[mask | (1 << j)] = (dp[mask] + nums[j]) % target;
      }
    }

    return dp[totalSubsets - 1] == 0;
  }

}

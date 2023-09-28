package problems._016_path_sum_3;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

  // Solution 1: Brute Force DFS

  public int pathSumDfsBruteForce(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    return pathSumHelper(root, targetSum) + pathSumDfsBruteForce(root.left, targetSum)
        + pathSumDfsBruteForce(root.right,
        targetSum);
  }

  private int pathSumHelper(TreeNode root, int targetSum) {
    int res = 0;
    if (root == null) {
      return res;
    }
    if (targetSum == root.val) {
      res++;
    }
    res += pathSumHelper(root.right, targetSum - root.val);
    res += pathSumHelper(root.left, targetSum - root.val);
    return res;
  }

  // Solution 2: DFS with Memoization

  private int count = 0;
  public int pathSumWithMemoization(TreeNode root, int targetSum) {
    count = 0;
    Map<Integer, Integer> oldSumFrequencyMap = new HashMap<>();
    oldSumFrequencyMap.put(0, 1);
    dfs(root, targetSum, oldSumFrequencyMap, 0);
    return count;
  }

  private void dfs(TreeNode root, int targetSum, Map<Integer, Integer> oldSumFrequencyMap,
      int currentSum) {
    if (root == null) {
      return;
    }
    currentSum += root.val;
    int freq = oldSumFrequencyMap.getOrDefault(currentSum - targetSum, 0);
    count += freq;
    oldSumFrequencyMap.put(currentSum, oldSumFrequencyMap.getOrDefault(currentSum, 0) + 1);
    dfs(root.left, targetSum, oldSumFrequencyMap, currentSum);
    dfs(root.right, targetSum, oldSumFrequencyMap, currentSum);
    oldSumFrequencyMap.put(currentSum, oldSumFrequencyMap.get(currentSum) - 1);
  }

  public static class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

  }

}

package algo._017_path_sum_1;

import algo.utils.TreeNode;

public class PathSum1 {

  // Solution I: Using DFS

  public boolean hasPathSumAddition(TreeNode root, int targetSum) {
    return hasPathSumHelper(root, targetSum, 0);
  }

  private boolean hasPathSumHelper(TreeNode root, int targetSum, int currentSum) {
    if (root == null) {
      return false;
    }
    currentSum += root.val;
    if (currentSum == targetSum && root.left == null && root.right == null) {
      return true;
    }
    return hasPathSumHelper(root.left, targetSum, currentSum) || hasPathSumHelper(root.right,
        targetSum, currentSum);
  }

  public boolean hasPathSumSubtraction(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    targetSum -= root.val;
    if (targetSum == 0 && root.left == null && root.right == null) {
      return true;
    }
    return hasPathSumSubtraction(root.left, targetSum) || hasPathSumSubtraction(root.right,
        targetSum);
  }

}

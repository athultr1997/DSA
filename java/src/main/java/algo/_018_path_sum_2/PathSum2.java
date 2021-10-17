package algo._018_path_sum_2;

import algo.utils.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> currentPath = new LinkedList<>();
    pathSumHelper(root, targetSum, currentPath, result);
    return result;
  }

  private void pathSumHelper(TreeNode root, int targetSum, List<Integer> currentPath,
      List<List<Integer>> result) {
    if (root == null) {
      return;
    }
    targetSum -= root.val;
    currentPath.add(root.val);
    if (targetSum == 0 && root.left == null && root.right == null) {
      result.add(new LinkedList<>(currentPath));
    }
    pathSumHelper(root.right, targetSum, currentPath, result);
    pathSumHelper(root.left, targetSum, currentPath, result);
    currentPath.remove(currentPath.size() - 1);
  }

}

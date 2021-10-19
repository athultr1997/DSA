package algo._022_house_robber_3;

import algo.utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

  // Solution I: DP + Memoization

  public int rob(TreeNode root) {
    Map<TreeNode, Integer> memo = new HashMap<>();
    return robHelper(root, memo);
  }

  private int robHelper(TreeNode root, Map<TreeNode, Integer> memo) {
    Integer m = memo.get(root);
    if (m != null) {
      return m;
    }
    if (root == null) {
      m = 0;
    } else {
      int m1 = robHelper(root.left, memo) + robHelper(root.right, memo);
      int m2 = root.val;
      if (root.left != null) {
        m2 += robHelper(root.left.right, memo) + robHelper(root.left.left, memo);
      }
      if (root.right != null) {
        m2 += robHelper(root.right.right, memo) + robHelper(root.right.left, memo);
      }
      m = Math.max(m1, m2);
    }
    memo.put(root, m);
    return m;
  }

  // Solution II: DP + Tabular + DFS

  public int robDp(TreeNode root) {
    int[] result = dfs(root);
    return Math.max(result[0], result[1]);
  }

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[2];
    }
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    int[] result = new int[2];
    result[0] = root.val + right[1] + left[1];
    result[1] = Math.max(right[1], right[0]) + Math.max(left[1], left[0]);
    return result;
  }

}

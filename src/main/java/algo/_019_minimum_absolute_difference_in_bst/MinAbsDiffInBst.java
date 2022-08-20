package algo._019_minimum_absolute_difference_in_bst;

import algo.utils.TreeNode;

public class MinAbsDiffInBst {

  int result;
  TreeNode prv;

  public int getMinimumDifference(TreeNode root) {
    prv = null;
    result = Integer.MAX_VALUE;
    inorder(root);
    return result;
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (prv != null) {
      result = Math.min(result, Math.abs(prv.val - root.val));
    }
    prv = root;
    inorder(root.right);
  }

}

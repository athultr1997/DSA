package problems._019_minimum_absolute_difference_in_bst;

import utils.TreeNode;

public class MinAbsDiffInBst {

  int result;
  TreeNode<Integer> prv;

  public int getMinimumDifference(TreeNode<Integer> root) {
    prv = null;
    result = Integer.MAX_VALUE;
    inorder(root);
    return result;
  }

  private void inorder(TreeNode<Integer> root) {
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

package algo._027_count_complete_tree_nodes;

import algo.utils.TreeNode;

public class Solution2 {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lh = 0;
    int rh = 0;
    TreeNode left = root;
    TreeNode right = root;
    while (left != null) {
      lh++;
      left = left.left;
    }
    while (right != null) {
      rh++;
      right = right.right;
    }
    if (lh == rh) {
      // can use bitwise operation: 'return (1 << lh) - 1;'
      return (int) Math.pow(2, lh) - 1;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

}

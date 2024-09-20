package problems._027_count_complete_tree_nodes;

import utils.TreeNode;

public class Solution1 {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

}

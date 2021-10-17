package algo._020_recover_bst;

import algo.utils.TreeNode;
import java.util.ArrayDeque;

public class RecoverBst {

  public void recoverTree(TreeNode root) {
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    TreeNode prv = new TreeNode(Integer.MIN_VALUE);
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.addLast(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (prv.val > root.val) {
        if (firstElement == null) {
          firstElement = prv;
        }
        if (firstElement != null) {
          secondElement = root;
        }
      }
      prv = root;
      root = root.right;
    }
    int tmp = firstElement.val;
    firstElement.val = secondElement.val;
    secondElement.val = tmp;
    return;
  }

  // TODO: Morris Traversal Solution


}

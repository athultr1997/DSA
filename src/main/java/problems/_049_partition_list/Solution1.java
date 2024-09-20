package problems._049_partition_list;

import utils.TreeNode;


public class Solution1 {
  public TreeNode<Integer> partition(TreeNode<Integer> head, int x) {
    if (head == null || head.left == null || x == 0) {
      return head;
    }
    TreeNode<Integer> cur = head;
    TreeNode<Integer> leftHead = new TreeNode<Integer>(Integer.MIN_VALUE);
    TreeNode<Integer> rightHead = new TreeNode<Integer>(Integer.MIN_VALUE);
    TreeNode<Integer> left = leftHead;
    TreeNode<Integer> right = rightHead;
    while (cur != null) {
      if (cur.val < x) {
        left.left = cur;
        left = left.left;
      } else {
        right.left = cur;
        right = right.left;
      }
      cur = cur.left;
    }
    right.left = null;
    left.left = rightHead.left;
    head = leftHead.left;
    return head;
  }
}

package problems._050_add_numbers_linked_list;

import java.util.Deque;
import java.util.LinkedList;
import utils.TreeNode;


public class Solution1 {
  public TreeNode<Integer> addTwoNumbers(TreeNode<Integer> l1, TreeNode<Integer> l2) {
    Deque<TreeNode<Integer>> q1 = new LinkedList<>();
    Deque<TreeNode<Integer>> q2 = new LinkedList<>();
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        q1.add(l1);
        l1 = l1.left;
      }
      if (l2 != null) {
        q2.add(l2);
        l2 = l2.left;
      }
    }

    int x1;
    int x2;
    int val;
    int digSum;
    int carry = 0;
    TreeNode<Integer> head = new TreeNode<Integer>(-1);
    while (!q1.isEmpty() || !q2.isEmpty() || carry != 0) {
      x1 = 0;
      x2 = 0;
      if (!q1.isEmpty()) {
        TreeNode<Integer> n1 = q1.removeLast();
        x1 = n1.val;
      }
      if (!q2.isEmpty()) {
        TreeNode<Integer> n2 = q2.removeLast();
        x2 = n2.val;
      }
      digSum = x1 + x2 + carry;
      val = digSum % 10;
      carry = digSum / 10;

      head.val = val;
      TreeNode<Integer> newHead = new TreeNode<Integer>(-1);
      newHead.left = head;
      head = newHead;
    }

    return head.left;
  }
}

package problems._052_linked_list_intersection;

import utils.TreeNode;


public class Solution1 {
  public TreeNode<Integer> getIntersectionNode(TreeNode<Integer> headA, TreeNode<Integer> headB) {
    TreeNode<Integer> curA = headA;
    TreeNode<Integer> curB = headB;

    while (true) {
      if (curA == curB) {
        return curA;
      }

      if (curA == null) {
        curA = headB;
      }
      if (curB == null) {
        curB = headA;
      }

      if (curA == curB) {
        return curA;
      }

      curA = curA.left;
      curB = curB.left;
    }
  }
}

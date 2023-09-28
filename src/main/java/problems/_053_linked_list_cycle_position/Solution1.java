package problems._053_linked_list_cycle_position;

import utils.TreeNode;


public class Solution1 {
  public TreeNode<Integer> detectCycle(TreeNode<Integer> head) {
    TreeNode<Integer> slow = head;
    TreeNode<Integer> fast = head;
    TreeNode<Integer> entry = head;
    while (fast != null && fast.left != null) {
      slow = slow.left;
      fast = fast.left.left;

      if (slow == fast) {
        while (slow != entry) {
          slow = slow.left;
          entry = entry.left;
        }
        return entry;
      }
    }
    return null;
  }
}

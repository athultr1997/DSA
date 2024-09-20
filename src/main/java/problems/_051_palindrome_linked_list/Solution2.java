package problems._051_palindrome_linked_list;

import utils.TreeNode;


public class Solution2 {
  public boolean isPalindrome(TreeNode<Integer> head) {
    TreeNode<Integer> slow = head;
    TreeNode<Integer> fast = head;
    while (fast != null && fast.left != null) {
      fast = fast.left.left;
      slow = slow.left;
    }

    // If the Linked List has odd number of nodes, keep the right half smaller.
    if (fast != null) {
      slow = slow.left;
    }

    // Reverse the right half.
    TreeNode<Integer> rightHead = slow;
    TreeNode<Integer> prev = null;
    TreeNode<Integer> next = null;
    while (rightHead != null) {
      next = rightHead.left;
      rightHead.left = prev;
      prev = rightHead;
      rightHead = next;
    }
    rightHead = prev;

    // Compare the left and the right half.
    while (rightHead != null) {
      if (rightHead.val != head.val) {
        return false;
      }
      head = head.left;
      rightHead = rightHead.left;
    }
    return true;
  }
}

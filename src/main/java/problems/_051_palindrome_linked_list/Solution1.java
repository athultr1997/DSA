package problems._051_palindrome_linked_list;

import java.util.Deque;
import java.util.LinkedList;
import utils.TreeNode;


public class Solution1 {
  public boolean isPalindrome(TreeNode<Integer> head) {
    int size = 0;
    TreeNode<Integer> fast = head;
    Deque<TreeNode<Integer>> stack = new LinkedList<>();
    while (fast != null) {
      stack.push(fast);
      fast = fast.left;
      size++;
    }

    int limit = size / 2;
    TreeNode<Integer> slow = head;
    for (int i = 0; i < limit; ++i) {
      TreeNode<Integer> node = stack.pop();
      if (slow.val != node.val) {
        return false;
      }
      slow = slow.left;
    }
    return true;
  }
}

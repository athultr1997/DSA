package problems._012_two_sum_bst;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class TwoSumBst {

  // Solution - 1

  public boolean findTarget(TreeNode root, int k) {
    Set<Integer> S = new HashSet<>(100, 1);
    return findTargetHelper(root, k, S);
  }

  private boolean findTargetHelper(TreeNode root, int k, Set<Integer> S) {
    if (root == null) {
      return false;
    }
    if (S.contains(k - root.val)) {
      return true;
    }
    S.add(root.val);
    return findTargetHelper(root.left, k, S) || findTargetHelper(root.right, k, S);
  }

  // Solution - 2

  public boolean findTargetUsingBstIterator(TreeNode root, int k) {
    BstIterator leftIterator = new BstIterator(root, false);
    BstIterator rightIterator = new BstIterator(root, true);
    TreeNode left = leftIterator.next();
    TreeNode right = rightIterator.next();
    while (left.val < right.val) {
      if (left.val + right.val == k) {
        return true;
      } else if (left.val + right.val > k) {
        right = rightIterator.next();
      } else {
        left = leftIterator.next();
      }
    }
    return false;
  }

  public static class BstIterator {

    private TreeNode current;

    private ArrayDeque<TreeNode> stack;

    private boolean reverse;

    public BstIterator(TreeNode root, boolean reverse) {
      this.current = root;
      this.stack = new ArrayDeque<>();
      this.reverse = reverse;
    }

    public TreeNode next() {
      while (current != null) {
        stack.addLast(current);
        current = reverse ? current.right : current.left;
      }
      TreeNode next = stack.removeLast();
      current = reverse ? next.left : next.right;
      return next;
    }
  }

  public static class TreeNode {

    TreeNode left;
    TreeNode right;
    Integer val;

  }

}

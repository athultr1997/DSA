package algo._013_bst_iterator;

import java.util.ArrayDeque;

public class BstIterator {

  private TreeNode current;
  private final ArrayDeque<TreeNode> stack;

  public BstIterator(TreeNode root) {
    current = root;
    stack = new ArrayDeque<>();
  }

  public int next() {
    while (current != null) {
      stack.addLast(current);
      current = current.left;
    }
    TreeNode next = stack.removeLast();
    current = next.right;
    return next.val;
  }

  public boolean hasNext() {
    return current != null || !stack.isEmpty();
  }

  public static class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public Integer val;

  }

}

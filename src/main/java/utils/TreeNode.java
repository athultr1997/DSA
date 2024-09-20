package utils;

public class TreeNode<T> {

  public TreeNode left;
  public TreeNode right;
  public T val;

  public TreeNode(T val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

}

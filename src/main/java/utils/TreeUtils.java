package utils;

public class TreeUtils {

  static final int COUNT = 10;

  public static <T> void printTree(TreeNode<T> root, int space) {
    if (root == null) {
      return;
    }
    space += COUNT;
    printTree(root.right, space);
    System.out.print("\n");
    for (int i = COUNT; i < space; i++) {
      System.out.print(" ");
    }
    System.out.print(root.val + "\n");
    printTree(root.left, space);
  }
}

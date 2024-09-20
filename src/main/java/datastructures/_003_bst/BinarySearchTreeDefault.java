package datastructures._003_bst;

import java.util.ArrayList;
import java.util.Stack;
import utils.TreeNode;
import utils.TreeUtils;


public class BinarySearchTreeDefault<T extends Comparable<T>> implements BinarySearchTree<T> {
  private TreeNode<T> root;

  public BinarySearchTreeDefault() {
    this.root = null;
  }

  @Override
  public void insert(T element) {
    if (this.root == null) {
      this.root = new TreeNode<T>(element);
      return;
    }
    TreeNode<T> current = this.root;
    TreeNode<T> prev = null;
    while (current != null) {
      int x = current.val.compareTo(element);
      prev = current;
      if (x < 0) {
        current = current.right;
      } else {
        current = current.left;
      }
    }

    if (prev.val.compareTo(element) < 0) {
      prev.right = new TreeNode<T>(element);
    } else {
      prev.left = new TreeNode<T>(element);
    }
  }

  @Override
  public void delete(T element) {

  }

  @Override
  public T successor(T element) {
//    return successor_using_inorder_traversal(element);
    return successor_using_bst_properties(element);
  }

  public T successor_using_inorder_traversal(T element) {
    Stack<TreeNode<T>> stack = new Stack<>();
    TreeNode<T> current = this.root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        current = stack.pop();
        if (current.val.compareTo(element) > 0) {
          return current.val;
        }
        current = current.right;
      }
    }
    return null;
  }

  public T successor_using_bst_properties(T element) {
    TreeNode<T> current = root;
    T successor = null;
    while(true) {
      if (current != null && current.val.compareTo(element) > 0) {
        successor = current.val;
        current = current.left;
      }
      else if (current != null && current.val.compareTo(element) < 0) {
        current = current.right;
      }
      else if (current != null && current.val.compareTo(element) == 0) {
        if (current.right != null) {
          return (T) minimum(current.right);
        }
        else {
          current = null;
        }
      }
      else {
        return successor;
      }
    }
  }

  @Override
  public T predecessor(T element) {
    TreeNode<T> current = this.root;
    T predecessor = null;
    while(true) {
      if (current != null && current.val.compareTo(element) > 0) {
        current = current.left;
      }
      else if (current != null && current.val.compareTo(element) < 0) {
        predecessor = current.val;
        current = current.right;
      }
      else if (current != null && current.val.compareTo(element) == 0) {
        if (current.left != null) {
          return (T) maximum(current.left);
        }
        else {
          current = null;
        }
      }
      else {
        return predecessor;
      }
    }
  }

  @Override
  public boolean search(T element) {
    TreeNode<T> current = this.root;
    while (current != null) {
      if (current.val == element) {
        return true;
      }
      if (current.val.compareTo(element) < 0) {
        current = current.right;
      }
      else {
        current = current.left;
      }
    }
    return false;
  }

  @Override
  public T maximum() {
    return maximum(this.root);
  }

  private T maximum(TreeNode<T> startNode) {
    TreeNode<T> current = startNode;
    if (current == null) {
      return null;
    }
    while (current.right != null) {
      current = current.right;
    }
    return current.val;
  }

  @Override
  public T minimum() {
    return minimum(this.root);
  }

  private T minimum(TreeNode<T> start) {
    TreeNode<T> current = start;
    if (current == null) {
      return null;
    }
    while (current.left != null) {
      current = current.left;
    }
    return current.val;
  }

  @Override
  public void isEmpty() {

  }

  @Override
  public void print() {
    TreeUtils.printTree(this.root, 3);
  }

  @Override
  public ArrayList<T> inorder_traversal() {
    ArrayList<T> inorder = new ArrayList<>();
    Stack<TreeNode<T>> stack = new Stack<>();
    TreeNode<T> current = this.root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        current = stack.pop();
        inorder.add(current.val);
        current = current.right;
      }
    }
    return inorder;
  }

  @Override
  public ArrayList<T> preorder_traversal() {
    return null;
  }

  @Override
  public ArrayList<T> postorder_traversal() {
    return null;
  }
}

package datastructures._003_bst;

import java.util.ArrayList;


public interface BinarySearchTree<T> {
  void insert(T element);
  void delete(T element);
  T successor(T element);
  T predecessor(T element);
  boolean search(T element);
  T maximum();
  T minimum();
  void isEmpty();
  void print();
   ArrayList<T> inorder_traversal();
  ArrayList<T> preorder_traversal();
  ArrayList<T> postorder_traversal();

}
